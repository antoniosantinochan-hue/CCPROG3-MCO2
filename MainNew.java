import databaseController.CharacterController;
import databaseController.MainMenuController;
import databaseModel.CharacterRegistryModel;
import databaseModel.Pirate;
import databaseView.*;

import java.util.*;

public class MainNew {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(myObj);
        CharacterRegistryModel characterRegistryModel = new CharacterRegistryModel();

        MainMenuView mainMenuView = new MainMenuView(inputHandler);
        CharacterView characterView = new CharacterView(inputHandler);
        PirateView pirateView = new PirateView(inputHandler);
        MarineView marineView = new MarineView(inputHandler);
        PirateHunterView pirateHunterView = new PirateHunterView(inputHandler);
        CivilianView civilianView = new CivilianView(inputHandler);

        CharacterController characterController = new CharacterController(
                characterRegistryModel,
                characterView,
                pirateView,
                marineView,
                pirateHunterView,
                civilianView
                );

        MainMenuController mainMenuController = new MainMenuController(
                mainMenuView,
                characterController
        );

        Pirate first = new Pirate("Johnny Tack", "a", "a",
                "Free", characterRegistryModel.getCharacterCount(),
                1);
        characterRegistryModel.addCharacter(first);

        mainMenuController.start();
    }
}
