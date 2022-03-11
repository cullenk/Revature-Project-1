package respositories;

import model.AdoptionRecord;
import model.Breed;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.BreedService;
import util.HibernateUtil;

import javax.persistence.Query;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;



public class AdoptionRecordRepository {
    public static final Logger log = Logger.getLogger(Driver.class);
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

            //Get the breed object to set the multiplicity relationship (breed_id)
            BreedService breedService = new BreedService();
            Breed chosenBreed = breedService.getBreedByName(breed);
            newRecord.setBreedObject(chosenBreed);

            log.info("Adoption Record Added: " + firstName + " " + lastName + " adopted a " + gender + " " + breed + "named " + puppy_name);

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
                log.info("Adoption Record Updated: " + id + " " + firstName + " " + lastName + " adopted a " + gender + " " + breed + "named " + puppy_name);
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
                log.info("Successfully deleted the record with id " + id);
                return true;
            }
            session.close();
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return false;
    }

    public List<AdoptionRecord> getAdoptionRecordByLastName(String lastName) throws IOException {
        try {
            Session session = HibernateUtil.getSession();
            org.hibernate.query.Query query = session.createQuery("FROM AdoptionRecord WHERE lastName = :lastName", AdoptionRecord.class);
            query.setParameter("lastName", lastName);
            List<AdoptionRecord> returnedRecord = query.list();
            session.close();
            System.out.println(returnedRecord.toString());
            log.info("Someone looked up the record for the user with the last name " + lastName);
            return returnedRecord;
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }

    public List<AdoptionRecord> getAdoptionRecordById(int id) throws IOException {
        try {
            Session session = HibernateUtil.getSession();
            org.hibernate.query.Query query = session.createQuery("FROM AdoptionRecord WHERE adoption_id = :id", AdoptionRecord.class);
            query.setParameter("id", id);
            List<AdoptionRecord> returnedRecord = query.list();
            session.close();
            return returnedRecord;
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }

    public List<AdoptionRecord> getMostPopularBreeds() throws IOException {
        try {
            Session session = HibernateUtil.getSession();
            SQLQuery query = session.createSQLQuery("SELECT breed_id, COUNT('breed_id') AS 'number_of_adoptions' FROM adoption_history GROUP BY breed_id ORDER BY 'number_of_adoptions' DESC");
            List<AdoptionRecord> returnedRecords = query.list();
            session.close();
            return returnedRecords;
        } catch (HibernateException | IOException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }
}
