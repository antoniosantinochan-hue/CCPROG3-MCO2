package databaseView;

import java.util.Scanner;

public class CharacterView {
    Scanner myObj;

    public CharacterView(Scanner myObj){
        this.myObj = myObj;
    }

    public String promptForName(){
        String name;

        System.out.print("Enter your character's name: ");
        name = myObj.nextLine();

        return name;
    }

    public String promptForAlias(){
        String alias;

        System.out.print("Enter your character's alias: ");
        alias = myObj.nextLine();

        return alias;
    }

    public String promptForOrigin(){
        String origin;

        System.out.print("Enter your character's origin: ");
        origin = myObj.nextLine();

        return origin;
    }

    public String promptForStatus(){
        String buffer;
        int status;

        while (true){
            System.out.println("1 - Free");
            System.out.println("2 - Captured");
            System.out.println("3 - Dead");
            System.out.print("Enter your character's status index: ");
            status = myObj.nextInt();
            buffer = myObj.nextLine();

            if (status >=1 && status <= 3){
                if (status == 1){
                    return "Free";
                }

                else if (status == 2){
                    return "Captured";
                }

                else{
                    return "Dead";
                }
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }
    }

    public double promptForBalance(){
        String buffer;
        double balance;

        System.out.print("Enter your character's balance: ");
        balance = myObj.nextDouble();
        buffer = myObj.nextLine();

        return balance;
    }

    public int promptForFaction(){
        String buffer;
        int faction;

        System.out.println("1 - Pirate");
        System.out.println("2 - Marine");
        System.out.println("3 - Pirate Hunter");
        System.out.println("4 - Civilian");
        System.out.print("Enter your character's faction index: ");
        faction = myObj.nextInt();
        buffer = myObj.nextLine();

        if (faction >= 1 && faction <= 4){
            return faction;
        }

        else{
            System.out.println("Please enter a valid index!");
            return -1;
        }
    }
}
