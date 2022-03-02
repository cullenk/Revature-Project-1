package application;

import model.Breed;
import model.Menu;
import services.BreedService;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {

        BreedService breedService = new BreedService();
        List<Breed> returnedBreeds = breedService.getBestBreedsForUser("large", "active", "a lot");

        for(Breed b : returnedBreeds){
            System.out.println(b.breed);
        }

//        Menu mainMenu = new Menu();
//        mainMenu.createMenu();
    }

}
