package databaseView;

import databaseModel.Marine;

public class MarineView {
    InputHandler inputHandler;

    public MarineView(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public String promptForRank(){
        String rank;
        rank = inputHandler.readNonEmptyString("Enter your marine's rank: ");

        return rank;
    }

    public void printMarineDetails(Marine m){
        System.out.println("MARINE DETAILS");
        System.out.printf("Character ID: %07d\n", m.getCHARACTER_ID());
        System.out.println("Name: " + m.getName());
        System.out.println("Alias: " + m.getAlias());
        System.out.println("Origin: " + m.getOrigin());
        System.out.println("Status: " + m.getStatus());
        if (m.getDevilFruitPower() == null){
            System.out.println("Devil Fruit Power: null");
        }
        else{
            System.out.println("Devil Fruit Power: " + m.getDevilFruitPower().getFruitName());
        }
        System.out.println("Wallet: " + m.getWallet());
        System.out.println("Rank: " + m.getRank());
        if (m.getMarineCorps() == null){
            System.out.println("Marine Corps Unit: null");
        }
        else{
            System.out.println("Marine Corps Unit: " + m.getMarineCorps().getName());
        }
    }
}
