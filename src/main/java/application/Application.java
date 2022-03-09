package application;

import model.Breed;
import services.AdoptionRecordService;
import services.BreedService;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {


        /*To Do
        -Add images?
        -Add exceptions for inputs or convert to radio buttons
        -Add Time stamp for adoption records?
        -What to do if there are no records or null is returned
        -Add Virtual Machine through Azure?
        -Add logging and testing
        -Method to just look at all the dog breed options in the system
         */

        BreedService breedService = new BreedService();
//        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("large", "active", "a lot");

//        AdoptionRecordService recordService = new AdoptionRecordService();


//        recordService.addNewAdoptionRecord("Jennifer", "Lawrence", "French Bulldog", "male", "Peeta");


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

        List<Breed> allBreeds = breedService.getAllBreeds();
        for(Breed b : allBreeds){
            System.out.println(b.breed);
        }

//        for(Breed breeds : returnedBreeds){
//            System.out.println(breeds.breed);
//        }

//        Menu mainMenu = new Menu();
//        mainMenu.createMenu();
    }

}
