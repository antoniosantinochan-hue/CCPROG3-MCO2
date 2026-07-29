package databaseView;

import java.util.Scanner;

public class PirateView {
    Scanner myObj;

    public PirateView(Scanner myObj){
        this.myObj = myObj;
    }

    public double promptForBounty(){
        double bounty;

        System.out.print("Enter your pirate's bounty: ");
        bounty = myObj.nextDouble();

        return bounty;
    }

    public void printPirateDetails(int CHARACTER_ID, String name, String alias,
                                   String origin, String status, String devilFruit,
                                   double wallet, double bounty, String role,
                                   String pirateCrew){
        System.out.println("PIRATE DETAILS");
        System.out.printf("Character ID: %07d\n", CHARACTER_ID);
        System.out.println("Name: " + name);
        System.out.println("Alias: " + alias);
        System.out.println("Origin: " + origin);
        System.out.println("Status: " + status);
        System.out.println("Devil Fruit Power: " + status);
        System.out.println("Wallet: " + wallet);
        System.out.println("Bounty: " + bounty);
        System.out.println("Role: " + role);
        System.out.println("Crew: " + pirateCrew);
    }
}
