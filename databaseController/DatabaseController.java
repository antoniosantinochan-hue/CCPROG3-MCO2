package databaseController;

import databaseModel.*;
import databaseView.*;

public class DatabaseController {
    private CharacterRegistryModel characterModel;
    private AffiliationModel affiliationModel;
    private DevilFruitModel devilFruitModel;
    private CharacterView characterView;

    public DatabaseController(CharacterRegistryModel charModel,
                              AffiliationModel affModel,
                              DevilFruitModel devModel,
                              CharacterView characterView){
        this.characterModel = charModel;
        this.affiliationModel = affModel;
        this.devilFruitModel = devModel;
        this.characterView = characterView;
    }


}
