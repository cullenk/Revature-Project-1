package application;

import model.AdoptionRecord;
import model.Breed;
import model.Menu;
import org.hibernate.Session;
import services.AdoptionRecordService;
import services.BreedService;
import util.HibernateUtil;

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
         */

        BreedService breedService = new BreedService();
//        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("large", "active", "a lot");

        AdoptionRecordService recordService = new AdoptionRecordService();
        recordService.deleteAdoptionRecord(3);

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

        List<AdoptionRecord> allAdoptionRecordsList = recordService.getAllAdoptionRecords();
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
