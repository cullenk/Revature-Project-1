package util;

import model.Breed;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Properties;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static Session getSession() throws IOException {
        //If not session exists yet, then we'll set one up.
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            //Load in our properties file that has the login credentials to connect to our SQL database.
            props.load(loader.getResourceAsStream("hibernate.properties"));
            configuration.setProperties(props);

            //Classes that will use this connection session. Each one should have an @Entity annotation tag to link them
            configuration.addAnnotatedClass(Breed.class);

            // ServiceRegistry to accept the connection and actually build it
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }
        return sessionFactory.openSession();
    }


}
