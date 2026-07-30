package databaseView;

import java.util.*;

public class MainMenuView {
    InputHandler inputHandler;

    public MainMenuView(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public int generateMainMenu(){
        int nInput;
        while (true){
            System.out.println("Main Menu");
            System.out.println("1 - Character Database");
            System.out.println("2 - Affiliation Database");
            System.out.println("3 - Devil Fruit Database");
            System.out.println("4 - Bounty System");
            System.out.println("5 - Exit program");
            nInput = inputHandler.readIntInRange("Enter your choice: ",
                    1, 5);

            return nInput;
        }
    }

    public int generateCharacterMenu(){
        int nInput;
        while (true){
            System.out.println("Character Database");
            System.out.println("1 - Add a new character");
            System.out.println("2 - View a character");
            System.out.println("3 - Modify a character");
            System.out.println("4 - Delete a character");
            System.out.println("5 - Exit menu");
            nInput = inputHandler.readIntInRange("Enter your choice: ",
                    1, 5);

            return nInput;
        }
    }

    public int generateAffiliationMenu(){
        int nInput;
        while (true){
            System.out.println("Affiliation Database");
            System.out.println("1 - Create Group");
            System.out.println("2 - View Groups");
            System.out.println("3 - Edit group attributes");
            System.out.println("4 - Add members");
            System.out.println("5 - Remove members");
            System.out.println("6 - Exit menu");
            nInput = inputHandler.readIntInRange("Enter your choice: ",
                    1, 6);

            return nInput;
        }
    }

    public int generateDevilFruitMenu(){
        int nInput;
        while (true){
            System.out.println("Devil Fruit Database");
            System.out.println("1 - Create a devil fruit");
            System.out.println("2 - View devil fruit");
            System.out.println("3 - Assign to a new user");
            System.out.println("4 - Exit menu");
            nInput = inputHandler.readIntInRange("Enter your choice: ",
                    1, 4);

            return nInput;
        }
    }

    public int generateBountySystemMenu(){
        int nInput;
        while (true){
            System.out.println("Bounty System Database");
            System.out.println("1 - Register a Capture");
            System.out.println("2 - View historical captures");
            System.out.println("3 - Exit menu");
            nInput = inputHandler.readIntInRange("Enter your choice: ",
                    1, 3);

            return nInput;
        }
    }

    public void sendFarewellMessage(){
        System.out.println("The program has been terminated. Farewell!");
    }
}
