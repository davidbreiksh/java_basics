import Data.Entity.Course;
import Data.Entity.LinkedPurchaseList;
import Data.Entity.PurchaseList;
import Data.Entity.Student;
import org.hibernate.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Connection connection = Connection.getInstance();
        Session session = connection.getSession();

        String hql = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseLists = session.createQuery(hql).getResultList();

        for (PurchaseList purchaseList : purchaseLists) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Course> courseCriteriaQuery = cb.createQuery(Course.class);
            Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);
            courseCriteriaQuery.select(courseRoot).where(cb.equal(courseRoot.get("name"), purchaseList.getCourseName()));
            Course course = session.createQuery(courseCriteriaQuery).getSingleResult();

            CriteriaQuery<Student> studentCriteriaQuery = cb.createQuery(Student.class);
            Root<Student> studentRoot = studentCriteriaQuery.from(Student.class);
            studentCriteriaQuery.select(studentRoot).where(cb.equal(studentRoot.get("name"), purchaseList.getStudentName()));
            Student student = session.createQuery(studentCriteriaQuery).getSingleResult();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setLinkedPurchaseList(new LinkedPurchaseList.LinkedPurchaseListKey(course.getId(), student.getId()));
            linkedPurchaseList.setCourseId(course.getId());
            linkedPurchaseList.setStudentId(student.getId());
            session.save(linkedPurchaseList);

        }
        session.getTransaction().commit();
        session.close();
    }
}