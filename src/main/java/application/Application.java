package application;

import model.TestPuppy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.TestPuppyService;

import java.util.List;

public class Application {
    public static void main(String[] args){

        TestPuppyService tps =  new TestPuppyService();

        System.out.println(tps.getPuppyById(1222).toString());

//        TestPuppy tp3 = new TestPuppy();
//        tp3.setPuppy_id(1224);
//        tp3.setPuppy_name("Bailey");
//        tp3.setPuppy_breed("Havanese");
//
//        TestPuppy tp4 = new TestPuppy();
//        tp4.setPuppy_id(1225);
//        tp4.setPuppy_name("Coda");
//        tp4.setPuppy_breed("German Shepherd");
//
//        tps.addPuppy(tp3);
//        tps.addPuppy(tp4);
//
//        List<TestPuppy> myPuppies = tps.getAllPuppies();
//        for(TestPuppy tp : myPuppies){
//            System.out.println(tp);
//        }

    }

}
