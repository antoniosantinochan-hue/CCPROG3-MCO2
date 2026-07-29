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
        mainMenuView.generateCharacterMenu();
    }
}
