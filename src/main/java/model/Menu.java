package model;

import services.BreedService;

import java.util.Scanner;

public class Menu {

    public Menu(){
    }

    public void createMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the breed you're searching for.");
        int id = scanner.nextInt();
        BreedService breedService = new BreedService();
        Breed returnedBreed = breedService.getBreedById(id);
        System.out.println("Here's the info of the puppy you requested: " + returnedBreed.breed_id + " " + returnedBreed.breed);
    }
}
