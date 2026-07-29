import databaseController.CharacterController;
import databaseModel.CharacterRegistryModel;
import databaseView.*;

import java.util.*;

public class MainNew {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        CharacterRegistryModel characterRegistryModel = new CharacterRegistryModel();

        CharacterView characterView = new CharacterView(myObj);
        PirateView pirateView = new PirateView(myObj);
        MarineView marineView = new MarineView(myObj);
        PirateHunterView pirateHunterView = new PirateHunterView(myObj);
        CivilianView civilianView = new CivilianView(myObj);

        CharacterController characterController = new CharacterController(
                characterRegistryModel,
                characterView,
                pirateView,
                marineView,
                pirateHunterView,
                civilianView
                );
    }
}
