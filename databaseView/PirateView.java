package databaseView;

import databaseModel.Pirate;
import java.util.Scanner;

public class PirateView {
    InputHandler inputHandler;

    public PirateView(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public double promptForBounty(){
        double bounty;
        bounty = inputHandler.readDouble("Enter your pirate's bounty: ");

        return bounty;
    }

    public String promptForRole(){
        String role;
        role = inputHandler.readNonEmptyString("Enter your pirate's role: ");

        return role;
    }

    public void printErrorMessage(int mode, Pirate p){
        if (mode == 1){
            System.out.println(p.getName() + " is already a " +
                    p.getRole() + "!");
        }
    }

    public void printPirateDetails(Pirate p){
        System.out.println("PIRATE DETAILS");
        System.out.printf("Character ID: %07d\n", p.getCHARACTER_ID());
        System.out.println("Name: " + p.getName());
        System.out.println("Alias: " + p.getAlias());
        System.out.println("Origin: " + p.getOrigin());
        System.out.println("Status: " + p.getStatus());
        if (p.getDevilFruitPower() == null){
            System.out.println("Devil Fruit Power: null");
        }
        else{
            System.out.println("Devil Fruit Power: " + p.getDevilFruitPower().getFruitName());
        }
        System.out.println("Wallet: " + p.getWallet());
        System.out.println("Bounty: " + p.getBounty());
        if (p.getRole() == null){
            System.out.println("Role: null");
        }
        else{
            System.out.println("Role: " + p.getRole());
        }
        if (p.getPirateCrew() == null){
            System.out.println("Crew: null");
        }
        else{
            System.out.println("Crew: " + p.getPirateCrew().getName());
        }
    }


}
