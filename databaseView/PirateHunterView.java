package databaseView;

import java.util.Scanner;

public class PirateHunterView {
    Scanner myObj;

    public PirateHunterView(Scanner myObj){
        this.myObj = myObj;
    }

    public String promptForCombatStyle(){
        String combatStyle;

        System.out.print("Enter your pirate hunter's combat style: ");
        combatStyle = myObj.nextLine();

        return combatStyle;
    }

    public int promptForConfirmedCaptures(){
        int confirmedCaptures;

        System.out.print("Enter your pirate hunter's confirmed capture count: ");
        confirmedCaptures = myObj.nextInt();

        return confirmedCaptures;
    }

    public void printPirateHunterDetails(int CHARACTER_ID, String name, String alias,
                                   String origin, String status, String devilFruit,
                                   double wallet, String combatStyle,
                                   String confirmedCaptures){
        System.out.println("PIRATE HUNTER DETAILS");
        System.out.printf("Character ID: %07d\n", CHARACTER_ID);
        System.out.println("Name: " + name);
        System.out.println("Alias: " + alias);
        System.out.println("Origin: " + origin);
        System.out.println("Status: " + status);
        System.out.println("Devil Fruit Power: " + status);
        System.out.println("Wallet: " + wallet);
        System.out.println("Combat Style: " + combatStyle);
        System.out.println("Confirmed Captures: " + confirmedCaptures);
    }
}
