package databaseController;

import databaseModel.*;
import databaseModel.Character;
import databaseModel.Exceptions.NoCrewException;
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

    protected void addCharacter(){
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

    private void addPirate(String name, String alias,
                          String origin, String status,
                          double balance){
        double bounty;
        bounty = pirateView.promptForBounty();

        Pirate temp = new Pirate(name, alias, origin, status,
                characterRegistryModel.getCharacterCount(),bounty);
        characterRegistryModel.addCharacter(temp);
        characterView.sendSuccessMessage(1,
                temp);
    }

    private void addMarine(String name, String alias,
                          String origin, String status,
                          double balance){
        String rank;
        rank = marineView.promptForRank();

        Marine temp = new Marine(name, alias, origin, status,
                characterRegistryModel.getCharacterCount(), rank);
        characterRegistryModel.addCharacter(temp);
        characterView.sendSuccessMessage(1,
                temp);
    }

    private void addPirateHunter(String name, String alias,
                          String origin, String status,
                          double balance){
        String style;
        int count;

        style = pirateHunterView.promptForCombatStyle();
        count = pirateHunterView.promptForConfirmedCaptures();

        PirateHunter temp = new PirateHunter(name, alias, origin,
                status, characterRegistryModel.getCharacterCount(), style, count);
        characterRegistryModel.addCharacter(temp);
        characterView.sendSuccessMessage(1,
                temp);
    }

    private void addCivilian(String name, String alias,
                          String origin, String status,
                          double balance){
        String profession, residence;

        profession = civilianView.promptForProfession();
        residence = civilianView.promptForResidence();

        Civilian temp = new Civilian(name, alias, origin,
                status, characterRegistryModel.getCharacterCount(),
                profession, residence);
        characterRegistryModel.addCharacter(temp);
        characterView.sendSuccessMessage(1,
                temp);
    }

    protected void displayCharacters(){
        characterView.displayCharacterRegistry(
                characterRegistryModel.getCharacterRegistry());
    }

    protected void viewProfile(){
        int choice;

        displayCharacters();
        choice = characterView.promptForCharacter(
                characterRegistryModel.getCharacterRegistry());


        if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof Pirate){
            pirateView.printPirateDetails(
                    (Pirate) characterRegistryModel.getCharacterRegistry().
                    get(choice-1));
        }

        else if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof Marine){
            marineView.printMarineDetails(
                    (Marine) characterRegistryModel.getCharacterRegistry().
                            get(choice-1));
        }

        else if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof PirateHunter){
            pirateHunterView.printPirateHunterDetails(
                    (PirateHunter) characterRegistryModel.getCharacterRegistry().
                            get(choice-1));
        }

        else if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof Civilian){
            civilianView.printCivilianDetails(
                    (Civilian) characterRegistryModel.getCharacterRegistry().
                            get(choice-1));
        }
    }

    protected void modifyCharacter(){
        int choice, action;

        displayCharacters();
        choice = characterView.promptForCharacter(
                characterRegistryModel.getCharacterRegistry());


        if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof Pirate){
            pirateView.printPirateDetails(
                    (Pirate) characterRegistryModel.getCharacterRegistry().
                            get(choice-1));
            action = characterView.displayModifyOptions(1);
        }

        else if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof Marine){
            marineView.printMarineDetails(
                    (Marine) characterRegistryModel.getCharacterRegistry().
                            get(choice-1));
            action = characterView.displayModifyOptions(2);
        }

        else if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof PirateHunter){
            pirateHunterView.printPirateHunterDetails(
                    (PirateHunter) characterRegistryModel.getCharacterRegistry().
                            get(choice-1));
            characterView.displayModifyOptions(3);
        }

        else if (characterRegistryModel.getCharacterRegistry().
                get(choice-1) instanceof Civilian){
            civilianView.printCivilianDetails(
                    (Civilian) characterRegistryModel.getCharacterRegistry().
                            get(choice-1));
            characterView.displayModifyOptions(4);
        }
    }

    private void changeAttributes(int mode, int action, Character c) throws NoCrewException {
        if (action >= 1 && action <= 5){
            if (action == 1){
                c.setName(characterView.promptForName());
            }

            else if (action == 2){
                c.setAlias(characterView.promptForAlias());
            }

            else if (action == 3){
                c.setStatus(characterView.promptForStatus());
            }

            else if (action == 4){
                c.setOrigin(characterView.promptForOrigin());
            }

            else{
                c.setWallet(characterView.promptForBalance());
            }
        }

        else if (action == 6){
            if (mode == 1){
                ((Pirate) c).assignBounty(pirateView.promptForBounty());
            }

            else if (mode == 2){
                ((Marine) c).promoteRank(marineView.promptForRank());
            }

            else if (mode == 3){
                ((PirateHunter) c).setCombatStyle(
                        pirateHunterView.promptForCombatStyle());
            }

            else{
                ((Civilian) c).setProfession(
                        civilianView.promptForProfession());
            }
        }

        else{
            if (mode == 1){
                ((Pirate) c).setRole(pirateView.promptForRole());
            }

            else if (mode == 3){

            }
        }
    }

    protected void deleteCharacter(){
        int choice;

        displayCharacters();
        choice = characterView.promptForCharacter(
                characterRegistryModel.getCharacterRegistry());

        characterView.sendSuccessMessage(2,
                characterRegistryModel.getCharacterRegistry().
                get(choice-1));
        characterRegistryModel.removeCharacter(choice-1);
    }
}
