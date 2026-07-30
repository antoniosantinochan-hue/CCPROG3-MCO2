package databaseView;

import databaseModel.Civilian;

import java.util.Scanner;

public class CivilianView {
    InputHandler inputHandler;

    public CivilianView(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public String promptForProfession(){
        String profession;
        profession = inputHandler.readNonEmptyString("Enter your civilian's profession: ");

        return profession;
    }

    public String promptForResidence(){
        String residence;
        residence = inputHandler.readNonEmptyString("Enter your civilian's residence: ");

        return residence;
    }

    public void printCivilianDetails(Civilian c){
        System.out.println("CIVILIAN DETAILS");
        System.out.printf("Character ID: %07d\n", c.getCHARACTER_ID());
        System.out.println("Name: " + c.getName());
        System.out.println("Alias: " + c.getAlias());
        System.out.println("Origin: " + c.getOrigin());
        System.out.println("Status: " + c.getStatus());
        if (c.getDevilFruitPower() == null){
            System.out.println("Devil Fruit Power: null");
        }
        else{
            System.out.println("Devil Fruit Power: " + c.getDevilFruitPower().getFruitName());
        }
        System.out.println("Wallet: " + c.getWallet());
        System.out.println("Profession: " + c.getProfession());
        System.out.println("Residence: " + c.getResidence());
    }
}
