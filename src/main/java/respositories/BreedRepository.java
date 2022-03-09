package respositories;

import model.Breed;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.query.Query;


public class BreedRepository {

    public List<Breed> getAllBreeds(){
        try {
            Session session = HibernateUtil.getSession();
            List<Breed> breedList = session.createQuery("FROM Breed", Breed.class).list();
            session.close();
            return breedList;
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }

    public List<Breed> getBreedDetails(String breed) throws IOException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Breed WHERE breed = :breed", Breed.class);
        query.setParameter("breed", breed);
        List<Breed> returnedBreed = query.list();
        session.close();
        return returnedBreed;
    }

    public List<Breed> getBestBreedsForUser(String size, String temperament, String sheds) throws IOException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Breed WHERE size = :size AND temperament = :temperament AND sheds = :sheds", Breed.class);
        query.setParameter("size", size);
        query.setParameter("temperament", temperament);
        query.setParameter("sheds", sheds);
        List<Breed> breedList = query.list();
        session.close();
        return breedList;
    }

 //  public boolean addBreed(Breed p){
//        try {
//            Session session = HibernateUtil.getSession();
//            Transaction transaction = session.beginTransaction();
//            session.persist(p);
//            transaction.commit();
//            session.close();
//            return true;
//
//        }catch(HibernateException | IOException e){
//            //e.printStackTrace();
//        }
//        return false;
//    }

//    public Breed getBreedById(int id){
//        try {
//            Session session = HibernateUtil.getSession();
//            Query query = session.createQuery("FROM Breed WHERE breed_id = :id", Breed.class);
//            query.setParameter("id", id);
//            List<Breed> breedList = query.list();
//            session.close();
//            if(breedList.size()==1){
//                return breedList.get(0);
//            }else{
//                return null;
//            }
//        }catch(HibernateException | IOException e){
//            e.printStackTrace();
//        }finally{
//        }
//        return null;
//    }


}
