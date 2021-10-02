import org.hibernate.*;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Connection connection = Connection.getInstance();
        Session session = connection.getSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        session.beginTransaction();
        CriteriaQuery<Object> cq = cb.createQuery(Object.class);
        Root<Course> root = cq.from(Course.class);
        cq.select(root.get("name"));
        Query query = session.createQuery(cq);

        List<Course> names = query.getResultList();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object> objectCriteriaQuery = criteriaBuilder.createQuery(Object.class);
        Root<Course> courseRoot = objectCriteriaQuery.from(Course.class);
        objectCriteriaQuery.select(courseRoot.get("studentCount"));
        Query query1 = session.createQuery(objectCriteriaQuery);

        List<Course> studentsCount = query1.getResultList();

        Iterator<Course> a = names.iterator();
        Iterator<Course> b = studentsCount.iterator();
        while (a.hasNext() && b.hasNext()) {
            System.out.println(a.next() + " - " + b.next() + " учеников");
        }
        session.getTransaction().commit();
        session.close();
    }
}