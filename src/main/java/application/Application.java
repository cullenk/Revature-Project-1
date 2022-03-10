package application;

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

        /*To Do
        -Multiplicity
        -Exception handling for typos or no results found.
        -Finish testing/mockito
         */
        AdoptionRecordService recordService = new AdoptionRecordService();
        BreedService breedService = new BreedService();
        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("large", "active", "a lot");



//        recordService.getAdoptionRecordByLastName("Kuch");
//        recordService.addNewAdoptionRecord("Jane", "Doe", "Poodle", "female", "Daisy");


//        Breed breed = new Breed();
//
//        breed.getNumberOfAdoptions().add(newRecord);
//        breed.getNumberOfAdoptions().add(newRecord2);

//        Session session = HibernateUtil.getSession();
//        session.beginTransaction();
//        session.save(breed);
//        session.save(newRecord);
//        session.save(newRecord2);
//        session.getTransaction().commit();
//        session.close();

//        List<Breed> allBreeds = breedService.getAllBreeds();
//        for(Breed b : allBreeds){
//            System.out.println(b.breed);
//        }

        for(Breed breeds : returnedBreeds){
            System.out.println(breeds.breed);
        }

//        Menu mainMenu = new Menu();
//        mainMenu.createMenu();
    }

}
