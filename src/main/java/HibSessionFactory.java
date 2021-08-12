import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibSessionFactory {
    private static SessionFactory factory;

    private HibSessionFactory() {}


    public static SessionFactory getSessionFactory(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr)
                .addAnnotatedClass(Consumer.class)
                .addAnnotatedClass(Good.class)
                .addAnnotatedClass(GoodsInfo.class)
                .getMetadataBuilder().build();

        SessionFactory factory = meta.buildSessionFactory();
        return factory;
    }
}
