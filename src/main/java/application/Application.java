package application;

import model.Menu;
import services.BreedService;

public class Application {
    public static void main(String[] args){

        BreedService bs =  new BreedService();

        Menu mainMenu = new Menu();
        mainMenu.createMenu();

//        Puppy newPuppy = new Puppy();
//
//
//
//        List<Puppy> allBreeds = ps.getAllPuppies();
//        for(Puppy p : myPuppies){
//            System.out.println(p);
//        }

    }

}
