package databaseController;

import databaseView.*;

public class MainMenuController {
    private MainMenuView mainMenuView;
    private CharacterController characterController;

    public MainMenuController(MainMenuView mainMenuView,
                              CharacterController characterController){
        this.mainMenuView = mainMenuView;
        this.characterController = characterController;
    }

    public void start(){
        boolean isRunning;

        isRunning = true;
        while (isRunning){
            int choice = mainMenuView.generateMainMenu();

            if (choice == 1){
                startCharacterMenu();
            }

            else if (choice == 2){

            }

            else if (choice == 3){

            }

            else if (choice == 4){

            }

            else if (choice == 5){
                isRunning = false;
                mainMenuView.sendFarewellMessage();
            }
        }
    }

    public void startCharacterMenu(){
        boolean isRunning;

        isRunning = true;
        while (isRunning){
            int choice = mainMenuView.generateCharacterMenu();

            if (choice == 1){
                characterController.addCharacter();
            }

            else if (choice == 2){
                characterController.viewProfile();
            }

            else if (choice == 3){
                characterController.modifyCharacter();
            }

            else if (choice == 4){
                characterController.deleteCharacter();
            }

            else if (choice == 5){
                isRunning = false;
            }
        }
    }
}
