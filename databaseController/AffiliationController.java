package databaseController;

import databaseModel.*;
import databaseModel.Character;
import databaseView.*;

public class AffiliationController {
    private AffiliationModel affiliationModel;

    public AffiliationController(AffiliationModel affiliationModel){
        this.affiliationModel = affiliationModel;
    }

    public void handleRemoveMemberFlow(PirateCrew crew, Character character) {
        /*
        try {
            crew.removeMember(character);
            view.displaySuccess(character.getName() + " has been removed from " + crew.getName() + ".");

            // Check if captain position needs to be assigned by user
            if (crew.getCaptain() == null && !crew.getRoster().isEmpty()) {
                view.displayInfo("The crew is now without a Captain! Please assign a new Captain.");
                // prompt user in view/controller to select a new captain...
            }

        } catch (CharacterNotFoundException e) {
            view.displayError(e.getMessage());
        }
        */
    }
}
