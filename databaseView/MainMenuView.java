package databaseView;

import java.util.*;

public class MainMenuView {
    Scanner myObj;

    public MainMenuView(Scanner myObj){
        this.myObj = myObj;
    }

    public void generateMainMenu(){
        int nInput;
        String buffer;
        boolean isRunning;

        isRunning = true;
        while (isRunning){
            System.out.println("Main Menu");
            System.out.println("1 - Character Database");
            System.out.println("2 - Affiliation Database");
            System.out.println("3 - Devil Fruit Database");
            System.out.println("4 - Bounty System");
            System.out.println("5 - Exit program");
            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput == 1){
                generateCharacterMenu();
            }

            else if (nInput == 5){
                isRunning = false;
                System.out.println("Program has been terminated. Farewell!");
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }
    }

    public int generateCharacterMenu(){
        int nInput;
        String buffer;
        boolean isRunning;

        isRunning = true;
        while (isRunning){
            System.out.println("Character Database");
            System.out.println("1 - Add a new character");
            System.out.println("2 - View a character");
            System.out.println("3 - Modify a character");
            System.out.println("4 - Delete a character");
            System.out.println("5 - Exit menu");
            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput >= 1 && nInput <= 4){
                isRunning = false;
                return nInput;
            }

            else if (nInput == 5){
                isRunning = false;
                System.out.println("Program has been terminated. Farewell!");
                return -1;
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }
    }
}
