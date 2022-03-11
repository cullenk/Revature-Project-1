package services;

import model.Breed;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreedServiceTest {

    BreedService breedService = new BreedService();

    @Test
    void GetsAllBreeds() throws IOException {
        List<Breed> allBreedsList = breedService.getAllBreeds();
    }

    @Test
    void GetsBreedDetails() throws IOException {
        List<Breed> testBreed = breedService.getBreedDetails("Mastiff");
        for (Breed b : testBreed) {
            assertTrue(b.breed.equalsIgnoreCase("Mastiff"));
        }
    }

    @Test
    void GetsOnlyTheBreedsBestSuitedForUser() throws IOException {
        String size = "large";
        String temperament = "mellow";
        String sheds = "a little";
        List<Breed> matchingBreedList = breedService.getBestBreedsForUser(size, temperament, sheds);
        for(Breed b : matchingBreedList){
            assertTrue(b.size.equalsIgnoreCase("large"));
        }
    }

    @Test
    void GetsTheBreedByName() throws IOException {
        String breedName = "Pug";
        Breed matchingBreed = breedService.getBreedByName(breedName);
        assertTrue(matchingBreed.breed.equalsIgnoreCase(breedName));
    }

}