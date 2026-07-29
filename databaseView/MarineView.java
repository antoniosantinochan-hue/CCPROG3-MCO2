package databaseView;

import java.util.Scanner;

public class MarineView {
    Scanner myObj;

    public MarineView(Scanner myObj){
        this.myObj = myObj;
    }

    public String promptForRank(){
        String rank;

        System.out.print("Enter your marine's rank: ");
        rank = myObj.nextLine();

        return rank;
    }

    public void printMarineDetails(int CHARACTER_ID, String name, String alias,
                                   String origin, String status, String devilFruit,
                                   double wallet, String rank,
                                   String marineCorps){
        System.out.println("MARINE DETAILS");
        System.out.printf("Character ID: %07d\n", CHARACTER_ID);
        System.out.println("Name: " + name);
        System.out.println("Alias: " + alias);
        System.out.println("Origin: " + origin);
        System.out.println("Status: " + status);
        System.out.println("Devil Fruit Power: " + status);
        System.out.println("Wallet: " + wallet);
        System.out.println("Rank: " + rank);
        System.out.println("Marine Corps Unit: " + marineCorps);
    }
}
