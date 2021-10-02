import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connection {

    private final StandardServiceRegistry registry;
    private final Metadata metadata;
    private final SessionFactory sessionFactory;
    private static Connection instance;

    private Connection() {
        registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}