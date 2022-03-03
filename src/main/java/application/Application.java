package application;

import model.Breed;
import model.Menu;
import services.BreedService;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {


        /*To Do

        -Add adoption record once finished.
        -Create flows for other CRUD methods
        -Create navbar to navigate to home
        -Add images?
        -Add exceptions for inputs or convert to radio buttons
         */


        BreedService breedService = new BreedService();
        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("large", "active", "a lot");

        for(Breed breeds : returnedBreeds){
            System.out.println(breeds.breed);
        }

//        Menu mainMenu = new Menu();
//        mainMenu.createMenu();
    }

}
