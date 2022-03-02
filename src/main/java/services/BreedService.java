package services;

import model.Breed;
import respositories.BreedRepository;

import java.io.IOException;
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
        if(br.getBreedById(b.getBreed_id()) == null){
            return br.addBreed(b);
        }else{
            return false;
        }
    }

    public List<Breed> getBestBreedsForUser(String size, String temperament, String sheds) throws IOException {
        return br.getBestBreedsForUser(size, temperament, sheds);
    }

}
