package services;

import model.Breed;
import respositories.BreedRepository;

import java.util.List;

public class BreedService {
    BreedRepository br;
    public BreedService(){
        br = new BreedRepository();
    }

    public Breed getBreedById(int id){
        return br.getBreedById(id);
    }

    public List<Breed> getAllBreeds(){
        return br.getAllBreeds();
    }

    public boolean addBreed(Breed b){
        if(br.getBreedById(b.getId()) == null){
            return br.addBreed(b);
        }else{
            return false;
        }
    }

}
