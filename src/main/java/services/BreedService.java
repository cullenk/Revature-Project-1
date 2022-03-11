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

    public List<Breed> getAllBreeds(){
        return br.getAllBreeds();
    }


    public List<Breed> getBreedDetails(String breed) throws IOException {
        return br.getBreedDetails(breed);
    }

    public List<Breed> getBestBreedsForUser(String size, String temperament, String sheds) throws IOException {
        return br.getBestBreedsForUser(size, temperament, sheds);
    }

    public Breed getBreedByName(String breed){
        return br.getBreedByName(breed);
    }

}
