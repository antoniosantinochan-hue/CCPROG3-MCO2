package databaseView;

import java.util.Scanner;

public class InputHandler {
    private Scanner myObj;

    public InputHandler(Scanner myObj){
        this.myObj = myObj;
    }

    public int readIntInRange(String prompt, int min, int max){
        String input;
        while (true){
            System.out.println(prompt);
            input = myObj.nextLine().trim();

            try{
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max){
                    return choice;
                }
            } catch(NumberFormatException e){

            }
            System.out.println("Please enter a valid input!");
        }
    }

    public int readInt(String prompt){
        String input;
        while (true){
            System.out.println(prompt);
            input = myObj.nextLine().trim();

            try{
                return Integer.parseInt(input);
            } catch(NumberFormatException e){

            }
            System.out.println("Please enter a valid input!");
        }
    }

    public double readDouble(String prompt){
        String input;
        while (true){
            System.out.println(prompt);
            input = myObj.nextLine().trim();

            try{
                return Double.parseDouble(input);
            } catch(NumberFormatException e){

            }
            System.out.println("Please enter a valid input!");
        }
    }

    public String readNonEmptyString(String prompt){
        String input;
        while (true){
            System.out.println(prompt);
            input = myObj.nextLine().trim();

            if (!input.isEmpty()){
                return input;
            }

            System.out.println("Please enter a valid input!");
        }
    }
}
