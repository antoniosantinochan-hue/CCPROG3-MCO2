package databaseView;

import databaseModel.PirateHunter;
import java.util.Scanner;

public class PirateHunterView {
    InputHandler inputHandler;

    public PirateHunterView(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public String promptForCombatStyle(){
        String combatStyle;
        combatStyle = inputHandler.readNonEmptyString("Enter your pirate hunter's combat style: ");

        return combatStyle;
    }

    public int promptForConfirmedCaptures(){
        int confirmedCaptures;
        confirmedCaptures = inputHandler.readInt("Enter your pirate hunter's confirmed capture count: ");

        return confirmedCaptures;
    }

    public void printPirateHunterDetails(PirateHunter h){
        System.out.println("PIRATE HUNTER DETAILS");
        System.out.printf("Character ID: %07d\n", h.getCHARACTER_ID());
        System.out.println("Name: " + h.getName());
        System.out.println("Alias: " + h.getAlias());
        System.out.println("Origin: " + h.getOrigin());
        System.out.println("Status: " + h.getStatus());
        if (h.getDevilFruitPower() == null){
            System.out.println("Devil Fruit Power: null");
        }
        else{
            System.out.println("Devil Fruit Power: " + h.getDevilFruitPower().getFruitName());
        }
        System.out.println("Wallet: " + h.getWallet());
        System.out.println("Combat Style: " + h.getCombatStyle());
        System.out.println("Confirmed Captures: " + h.getConfirmedCaptures());
    }
}
