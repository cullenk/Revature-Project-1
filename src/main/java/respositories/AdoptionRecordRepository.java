package respositories;

import model.AdoptionRecord;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.Query;
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

    public AdoptionRecord addNewAdoptionRecord(String firstName, String lastName, String breed, String gender, String puppy_name){
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();

            AdoptionRecord newRecord = new AdoptionRecord();
            newRecord.setFirstName(firstName);
            newRecord.setLastName(lastName);
            newRecord.setBreed(breed);
            newRecord.setGender(gender);
            newRecord.setPuppy_name(puppy_name);


            session.persist(newRecord);
            transaction.commit();
            session.close();
            return newRecord;
        }catch(HibernateException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean updateAdoptionRecord(int id, String firstName, String lastName, String breed, String gender, String puppy_name) {
        try {
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("UPDATE AdoptionRecord SET firstName=:firstName, lastName=:lastName, breed=:breed, gender=:gender, puppy_name=:puppy_name WHERE adoption_id = :id");
            query.setParameter("id", id);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            query.setParameter("breed", breed);
            query.setParameter("gender", gender);
            query.setParameter("puppy_name", puppy_name);

            session.beginTransaction();
            int executeUpdate = query.executeUpdate();
            session.getTransaction().commit();
            if(executeUpdate > 0){
                System.out.println("Successfully updated the record with Id: " + id);
                return true;
            }
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return false;
    }

    public boolean deleteAdoptionRecord(int id) {
        try {
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("DELETE FROM AdoptionRecord WHERE adoption_id = :id");
            query.setParameter("id", id);

            session.beginTransaction();
            int executeUpdate = query.executeUpdate();
            session.getTransaction().commit();
            if(executeUpdate > 0){
                System.out.println("Successfully deleted the record with Id: " + id);
                return true;
            }
            session.close();
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return false;
    }

}
