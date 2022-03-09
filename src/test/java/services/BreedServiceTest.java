package services;

import model.Breed;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreedServiceTest {

//    @Test
//    void GetAllBreeds() throws IOException {
//        BreedService breedService = new BreedService();
//        List<Breed> allBreedsList = breedService.getAllBreeds();
//    }

    @Test
    void GetBreedDetails() throws IOException {
        BreedService breedService = new BreedService();
        List<Breed> testBreed = breedService.getBreedDetails("Mastiff");
        for (Breed b : testBreed) {
            assertTrue(b.breed.equalsIgnoreCase("Mastiff"));
        }
    }

    @Test
    void GetsOnlyTheBreedsBestSuitedForUser() throws IOException {
        BreedService breedService = new BreedService();
        String size = "large";
        String temperament = "mellow";
        String sheds = "a little";
        List<Breed> matchingBreedList = breedService.getBestBreedsForUser(size, temperament, sheds);
        for(Breed b : matchingBreedList){
            assertTrue(b.size.equalsIgnoreCase("large"));
        }
    }
}