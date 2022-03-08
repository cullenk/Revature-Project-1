package application;

import model.AdoptionRecord;
import model.Breed;
import model.Menu;
import services.AdoptionRecordService;
import services.BreedService;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {


        /*To Do

        -Add adoption record once finished.
        -Create flows for other CRUD methods
        -Add images?
        -Add exceptions for inputs or convert to radio buttons
        -Add Time stamp for adoption records?
        -What to do if there are no records or null is returned
        -Add Virtual Machine through Azure?
        -Add logging and testing
         */




//        BreedService breedService = new BreedService();
//        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("large", "active", "a lot");

        AdoptionRecordService recordService = new AdoptionRecordService();
        List<AdoptionRecord> allAdoptionRecordsList = recordService.getAllAdoptionRecords();

//    recordService.addNewAdoptionRecord("John", "Krasinski", "Pug", "female", "Emily");

        for(AdoptionRecord adr : allAdoptionRecordsList){
            System.out.println(adr);
        }

//        for(Breed breeds : returnedBreeds){
//            System.out.println(breeds.breed);
//        }

//        Menu mainMenu = new Menu();
//        mainMenu.createMenu();
    }

}
