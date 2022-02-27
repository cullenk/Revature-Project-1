package services;

import model.TestPuppy;
import respositories.TestPuppyRepository;

import java.util.List;

public class TestPuppyService {
    TestPuppyRepository tpr;
    public TestPuppyService(){
        tpr = new TestPuppyRepository();
    }


    public TestPuppy getPuppyById(int id){
        return tpr.getPuppyById(id);
    }
    public List<TestPuppy> getAllPuppies(){
        return tpr.getAllPuppies();
    }
    public boolean addPuppy(TestPuppy p){
        if(tpr.getPuppyById(p.getPuppy_id()) == null){
            return tpr.addPuppy(p);
        }else{
            return false;
        }
    }

}
