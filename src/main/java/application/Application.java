package application;

import model.Puppy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args){
        Puppy testPuppy = new Puppy();
        testPuppy.setPuppy_id(1);
        testPuppy.setPuppy_name("Cooper");
        testPuppy.setPuppy_Breed("Chocolate Lab");

        Configuration con = new Configuration();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.save(testPuppy);
    }
}
