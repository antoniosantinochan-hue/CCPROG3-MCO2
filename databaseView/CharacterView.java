package databaseView;

import databaseModel.Character;
import java.util.ArrayList;

public class CharacterView {
    InputHandler inputHandler;

    public CharacterView(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public String promptForName(){
        String name;
        name = inputHandler.readNonEmptyString("Enter your character's name: ");

        return name;
    }

    public String promptForAlias(){
        String alias;
        alias = inputHandler.readNonEmptyString("Enter your character's alias: ");

        return alias;
    }

    public String promptForOrigin(){
        String origin;
        origin = inputHandler.readNonEmptyString("Enter your character's origin: ");

        return origin;
    }

    public String promptForStatus(){
        int status;

        while (true){
            System.out.println("1 - Free");
            System.out.println("2 - Captured");
            System.out.println("3 - Dead");
            status = inputHandler.readIntInRange("Enter your character's status index: ",
                    1, 3);

            return switch(status){
                case 1 -> "Free";
                case 2 -> "Captured";
                case 3 -> "Dead";
                default -> "Unknown";
            };
        }
    }

    public double promptForBalance(){
        double balance;
        balance = inputHandler.readDouble("Enter your character's balance: ");

        return balance;
    }

    public int promptForFaction(){
        int faction;

        while (true){
            System.out.println("1 - Pirate");
            System.out.println("2 - Marine");
            System.out.println("3 - Pirate Hunter");
            System.out.println("4 - Civilian");
            faction = inputHandler.readIntInRange("Enter your character's faction index: ",
                    1, 4);

            return faction;
        }
    }

    public void displayCharacterRegistry(ArrayList<Character>
                                                 characterRegistry){
        int index = 1;
        if (!characterRegistry.isEmpty()){
            System.out.println("--CHARACTER REGISTRY--");
            for (Character c: characterRegistry){
                System.out.println(index + ". " +
                        characterRegistry.get(index - 1).getName() +
                        " (" +
                        characterRegistry.get(index - 1).getClass().getSimpleName()
                        + ")");
                index++;
            }
        }

        else{
            System.out.println("There are no characters in the registry!");
        }
    }

    public int displayModifyOptions(int mode){
        int nInput = -1;
        System.out.println("Which would you like to modify?");
        System.out.println("1 - Name");
        System.out.println("2 - Alias");
        System.out.println("3 - Status");
        System.out.println("4 - Origin");
        System.out.println("5 - Wallet");

        if (mode == 1){
            System.out.println("6 - Bounty");
            System.out.println("7 - Role");
        }

        else if (mode == 2){
            System.out.println("6 - Rank");
        }

        else if (mode == 3){
            System.out.println("6 - Combat Style");
            System.out.println("7 - Confirmed Captures");
        }

        else if (mode == 4){
            System.out.println("6 - Profession");
            System.out.println("7 - Residence");
        }

        if (mode == 1 || mode >= 3 && mode <= 4){
            nInput = inputHandler.readIntInRange("Enter your choice: ",
                    1, 7);
        }

        else if (mode == 2){
            nInput = inputHandler.readIntInRange("Enter your choice: ",
                    1, 6);
        }
        return nInput;
    }

    public int promptForCharacter(ArrayList<Character>
                                          characterRegistry){
        int choice;
        while (true){
            displayCharacterRegistry(characterRegistry);
            choice = inputHandler.readIntInRange("Enter your choice: ",
                    1, characterRegistry.size());

            return choice;
        }
    }

    public void sendSuccessMessage(int mode, Character c){
        if (mode == 1){
            System.out.println("You have successfully added " +
                    c.getName() + " into the character registry!");
        }

        else if (mode == 2){
            System.out.println("You have successfully removed " +
                    c.getName() + " from the character registry!");
        }
    }
}
