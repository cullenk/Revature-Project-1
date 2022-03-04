package respositories;

import model.AdoptionRecord;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.io.IOException;
import java.util.List;

public class AdoptionRecordRepository {

    public List<AdoptionRecord> getAdoptionRecords(){
        try {
            Session session = HibernateUtil.getSession();
            List<AdoptionRecord> adoptionRecordList = session.createQuery("FROM AdoptionRecord", AdoptionRecord.class).list();
            session.close();
            return adoptionRecordList;
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }

//    public boolean addNewAdoptionRecord(String firstName, String lastName, String breed, String gender, String puppy_name){
//        try {
//            Session session = HibernateUtil.getSession();
//            Transaction transaction = session.beginTransaction();
//
//            session.persist();
//            session.close();
//            return true;
//        }catch(HibernateException | IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
