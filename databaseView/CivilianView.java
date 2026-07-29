package databaseView;

import java.util.Scanner;

public class CivilianView {
    Scanner myObj;

    public CivilianView(Scanner myObj){
        this.myObj = myObj;
    }

    public String promptForProfession(){
        String profession;

        System.out.print("Enter your civilian's profession: ");
        profession = myObj.nextLine();

        return profession;
    }

    public String promptForResidence(){
        String residence;

        System.out.print("Enter your civilian's residence: ");
        residence = myObj.nextLine();

        return residence;
    }

    public void printCivilianDetails(int CHARACTER_ID, String name, String alias,
                                         String origin, String status, String devilFruit,
                                         double wallet, String profession,
                                         String residence){
        System.out.println("CIVILIAN DETAILS");
        System.out.printf("Character ID: %07d\n", CHARACTER_ID);
        System.out.println("Name: " + name);
        System.out.println("Alias: " + alias);
        System.out.println("Origin: " + origin);
        System.out.println("Status: " + status);
        System.out.println("Devil Fruit Power: " + status);
        System.out.println("Wallet: " + wallet);
        System.out.println("Profession: " + profession);
        System.out.println("Residence: " + residence);
    }
}
