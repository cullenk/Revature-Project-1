package application;

import model.AdoptionRecord;
import model.Breed;
import services.AdoptionRecordService;
import services.BreedService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

public class Application {
    public static final Logger log = Logger.getLogger(Driver.class);
    public static void main(String[] args) throws IOException {

        log.info("Hello Logger!");

        AdoptionRecordService recordService = new AdoptionRecordService();
        BreedService breedService = new BreedService();
        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("large", "active", "a lot");

//        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("small", "active", "a lot");

//        List<AdoptionRecord> returnedRecords = recordService.getAdoptionRecordById(5);
//        recordService.addNewAdoptionRecord("Alex", "Levy", "Dalmatian", "male", "Roger");

//        for(AdoptionRecord ar : returnedRecords){
//            System.out.println(ar.adoption_id);
//            System.out.println(ar.firstName);
//            System.out.println(ar.lastName);
//            System.out.println(ar.breed);
//            System.out.println(ar.puppy_name);
//            System.out.println(ar.getBreedObject().breed_id);
//        }

//        for(Breed breeds : returnedBreeds){
//            System.out.println(breeds.breed);
//        }

        String breedName = "Pug";
        Breed matchingBreed = breedService.getBreedByName(breedName);
        System.out.println(matchingBreed.breed);

    }

}
