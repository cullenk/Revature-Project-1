package respositories;

import model.TestPuppy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.io.IOException;
import java.util.List;
import org.hibernate.query.Query;


public class TestPuppyRepository {
    public boolean addPuppy(TestPuppy p){
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(p);
            transaction.commit();
            session.close();
            return true;

        }catch(HibernateException | IOException e){
            //e.printStackTrace();
        }
        return false;
    }
    public List<TestPuppy> getAllPuppies(){
        try {
            Session session = HibernateUtil.getSession();
            List<TestPuppy> puppyList = session.createQuery("FROM TestPuppy", TestPuppy.class).list();
            session.close();
            return puppyList;
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }

    public TestPuppy getPuppyById(int id){
        try {
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM TestPuppy WHERE puppy_id = :id", TestPuppy.class);
            query.setParameter("id", id);
            List<TestPuppy> puppyList = query.list();
            session.close();
            if(puppyList.size()==1){
                return puppyList.get(0);
            }else{
                return null;
            }
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }
}
