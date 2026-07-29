package databaseController;

import databaseModel.*;
import databaseView.*;

public class CharacterController {
    private CharacterRegistryModel characterRegistryModel;
    private CharacterView characterView;
    private PirateView pirateView;
    private MarineView marineView;
    private PirateHunterView pirateHunterView;
    private CivilianView civilianView;

    public CharacterController(CharacterRegistryModel characterRegistryModel,
                               CharacterView characterView,
                               PirateView pirateView,
                               MarineView marineView,
                               PirateHunterView pirateHunterView,
                               CivilianView civilianView){
        this.characterRegistryModel = characterRegistryModel;
        this.characterView = characterView;
        this.pirateView = pirateView;
        this.marineView = marineView;
        this.pirateHunterView = pirateHunterView;
        this.civilianView = civilianView;
    }

    public void addCharacter(){
        int faction;

        faction = characterView.promptForFaction();
        if (faction == 1){
            addPirate(characterView.promptForName(),
                    characterView.promptForAlias(),
                    characterView.promptForOrigin(),
                    characterView.promptForStatus(),
                    characterView.promptForBalance());
        }

        else if (faction == 2){
            addMarine(characterView.promptForName(),
                    characterView.promptForAlias(),
                    characterView.promptForOrigin(),
                    characterView.promptForStatus(),
                    characterView.promptForBalance());
        }

        else if (faction == 3){
            addPirateHunter(characterView.promptForName(),
                    characterView.promptForAlias(),
                    characterView.promptForOrigin(),
                    characterView.promptForStatus(),
                    characterView.promptForBalance());
        }

        else if (faction == 4){
            addCivilian(characterView.promptForName(),
                    characterView.promptForAlias(),
                    characterView.promptForOrigin(),
                    characterView.promptForStatus(),
                    characterView.promptForBalance());
        }
    }

    public void addPirate(String name, String alias,
                          String origin, String status,
                          double balance){
        double bounty;
        bounty = pirateView.promptForBounty();

        Pirate temp = new Pirate(name, alias, origin, status,
                characterRegistryModel.getCharacterCount(),bounty);
        characterRegistryModel.addCharacter(temp);
    }

    public void addMarine(String name, String alias,
                          String origin, String status,
                          double balance){
        String rank;
        rank = marineView.promptForRank();

        Marine temp = new Marine(name, alias, origin, status,
                characterRegistryModel.getCharacterCount(), rank);
        characterRegistryModel.addCharacter(temp);
    }

    public void addPirateHunter(String name, String alias,
                          String origin, String status,
                          double balance){
        String style;
        int count;

        style = pirateHunterView.promptForCombatStyle();
        count = pirateHunterView.promptForConfirmedCaptures();

        PirateHunter temp = new PirateHunter(name, alias, origin,
                status, characterRegistryModel.getCharacterCount(), style, count);
        characterRegistryModel.addCharacter(temp);
    }

    public void addCivilian(String name, String alias,
                          String origin, String status,
                          double balance){
        String profession, residence;

        profession = civilianView.promptForProfession();
        residence = civilianView.promptForResidence();

        Civilian temp = new Civilian(name, alias, origin,
                status, characterRegistryModel.getCharacterCount(),
                profession, residence);
        characterRegistryModel.addCharacter(temp);
    }

}
