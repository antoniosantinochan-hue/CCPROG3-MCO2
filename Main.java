import java.util.*;
import databaseModel.*;
import databaseModel.Character;

/**
 This is the Main/ driver class where the program is primarily run.
 */
public class Main {
    // declaration of scanner and array list objects
    private static Scanner myObj = new Scanner(System.in);
    public static ArrayList<Character> characterRegistry =
            new ArrayList<Character>();
    public static ArrayList<Affiliation> affiliationRegistry =
            new ArrayList<Affiliation>();
    public static ArrayList<DevilFruit> devilFruitRegistry =
            new ArrayList<>();
    public static ArrayList<Capture> captureRegistry =
            new ArrayList<>();


    public static int characterCount = 0;
    public static int affiliationCount = 0;
    public static int devilFruitCount = 0;
    public static int captureCount = 0;

    /**
     * This method serves as a menu for character creation.
     *     Parameters : None
     *     Returns : void
     */
    private static void addCharacter(){
        String name, alias, origin, status;
        String buffer;
        double balance;
        int nInput;

        System.out.print("Enter your character's name: ");
        name = myObj.nextLine();

        System.out.print("Enter your character's alias: ");
        alias = myObj.nextLine();

        System.out.print("Enter your character's origin: ");
        origin = myObj.nextLine();

        System.out.println("1 - Free");
        System.out.println("2 - Captured");
        System.out.println("3 - Dead");
        System.out.print("Enter your character's status index: ");
        nInput = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nInput >= 1 && nInput <= 3){
            if (nInput == 1){
                status = "Free";
            }

            else if (nInput == 2){
                status = "Captured";
            }

            else{
                status = "Dead";
            }

            System.out.print("Enter your character's wallet balance: ");
            balance = myObj.nextDouble();
            buffer = myObj.nextLine();

            System.out.println("1 - Pirate");
            System.out.println("2 - Marine");
            System.out.println("3 - Pirate Hunter");
            System.out.println("4 - Civilian");
            System.out.print("Enter your character's faction index: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput >= 1 && nInput <= 4){
                if (nInput == 1){
                    createPirate(name, alias, origin, status, balance);
                }

                else if (nInput == 2){
                    createMarine(name, alias, origin, status, balance);
                }

                else if (nInput == 3){
                    createHunter(name, alias, origin, status, balance);
                }

                else{
                    createCivilian(name, alias, origin, status, balance);
                }

            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }

        else{
            System.out.println("Please enter a valid index!");
        }

    }

    /**
     * This method serves as a menu for pirate creation.
     *     It is called when the user selects Pirate in character creation.
     *     Returns : void
     *
     * @param name name of the pirate
     * @param alias alias of the pirate
     * @param origin origin of the pirate
     * @param status status of the pirate
     * @param balance balance of the pirate
     */
    private static void createPirate(String name, String alias,
                                          String origin, String status,
                                          double balance){
        int nInput;
        double bounty;
        String role;
        String buffer;

        System.out.print("Enter your pirate's bounty: ");
        bounty = myObj.nextDouble();
        buffer = myObj.nextLine();

        Pirate temp = new Pirate(name, alias, origin, status,
                ++characterCount,bounty);
        characterRegistry.add(temp);

        System.out.println(temp.getName() + " has been successfully added "
        + " to the character registry!");
    }

    /**
     *     This method serves as a menu for marine creation.
     *     It is called when the user selects Marine in character creation.
     *      Returns : void
     *
     * @param name name of the marine
     * @param alias alias of the marine
     * @param origin origin of the marine
     * @param status status of the marine
     * @param balance balance of the marine
     */
    private static void createMarine(String name, String alias,
                                     String origin, String status,
                                     double balance){
        int nInput;
        String rank;
        String buffer;

        System.out.println("1 - Fleet Admiral");
        System.out.println("2 - Admiral");
        System.out.println("3 - Vice Admiral");
        System.out.print("Enter your marine's rank index: ");
        nInput = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nInput >= 1 && nInput <= 3){
            if (nInput == 1){
                rank = "Fleet Admiral";
            }

            else if (nInput == 2){
                rank = "Admiral";
            }

            else{
                rank = "Vice Admiral";
            }

            Marine temp = new Marine(name, alias, origin, status,
                    ++characterCount, rank);
            characterRegistry.add(temp);
            System.out.println(temp.getName() + " has been successfully added "
                    + " to the character registry!");
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method serves as a menu for hunter creation.
     *         It is called when the user selects Hunter in character creation.
     *         Returns : void
     *
     * @param name name of the hunter
     * @param alias alias of the hunter
     * @param origin origin of the hunter
     * @param status status of the hunter
     * @param balance balance of the hunter
     */
    private static void createHunter(String name, String alias,
                                     String origin, String status,
                                     double balance){
        int nInput;
        int count;
        String style;
        String buffer;

        System.out.println("1 - Three-Sword Style");
        System.out.println("2 - Sniper");
        System.out.println("3 - Brawler");
        System.out.print("Enter your hunter's combat style index: ");
        nInput = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nInput >= 1 && nInput <= 3){
            if (nInput == 1){
                style = "Three-Sword Style";
            }

            else if (nInput == 2){
                style = "Sniper";
            }

            else{
                style = "Brawler";
            }

            System.out.print("Enter your hunter's confirmed capture count: ");
            count = myObj.nextInt();

            PirateHunter temp = new PirateHunter(name, alias, origin,
                    status, ++characterCount, style, count);
            characterRegistry.add(temp);
            System.out.println(temp.getName() + " has been successfully added "
                    + " to the character registry!");
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method serves as a menu for civilian creation.
     *         It is called when the user selects Civilian in character creation.
     *          Returns : void
     *
     * @param name name of the civilian
     * @param alias alias of the civilian
     * @param origin origin of the civilian
     * @param status status of the civilian
     * @param balance balance of the civilian
     */
    private static void createCivilian(String name, String alias,
                                     String origin, String status,
                                     double balance){
        int nInput;
        String profession, residence;
        String buffer;

        System.out.println("1 - Shipwright");
        System.out.println("2 - Bartender");
        System.out.println("3 - Scholar");
        System.out.print("Enter your civilian's profession index: ");
        nInput = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nInput >= 1 && nInput <= 3){
            if (nInput == 1){
                profession = "Shipwright";
            }

            else if (nInput == 2){
                profession = "Bartender";
            }

            else{
                profession = "Scholar";
            }

            System.out.print("Enter your civilian's residence: ");
            residence = myObj.nextLine();

            Civilian temp = new Civilian(name, alias, origin,
                    status, ++characterCount,
                    profession, residence);
            characterRegistry.add(temp);
            System.out.println(temp.getName() + " has been successfully added "
                    + " to the character registry!");
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method serves as a menu for character modification.
     *         Parameters : None
     *         Returns : void
     */
    private static void modifyCharacter(){
        int nChar, nInput, tempInt;
        double tempDouble;
        String temp;
        String buffer;

        displayCharacters();
        System.out.print("Enter your character's index: ");
        nChar = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nChar >= 1 && nChar <= characterRegistry.size()){
            characterRegistry.get(nChar-1).displayProfile();
            System.out.println("Which would you like to modify?");
            System.out.println("1 - Name");
            System.out.println("2 - Alias");
            System.out.println("3 - Status");
            System.out.println("4 - Origin");
            System.out.println("5 - Wallet");

            if (characterRegistry.get(nChar-1) instanceof Pirate){
                System.out.println("6 - Bounty");
                System.out.println("7 - Role");
            }

            else if (characterRegistry.get(nChar-1) instanceof Marine){
                System.out.println("6 - Rank");
            }

            else if (characterRegistry.get(nChar-1) instanceof Civilian){
                System.out.println("6 - Profession");
                System.out.println("7 - Residence");
            }

            else if (characterRegistry.get(nChar-1) instanceof PirateHunter){
                System.out.println("6 - Combat Style");
                System.out.println("7 - Confirmed Captures");
            }

            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput >= 1 && nInput <= 5){
                if (nInput == 1){
                    System.out.print("Enter your character's new name: ");
                    temp = myObj.nextLine();
                    characterRegistry.get(nChar-1).setName(temp);
                }

                else if (nInput == 2){
                    System.out.print("Enter your character's new alias: ");
                    temp = myObj.nextLine();
                    characterRegistry.get(nChar-1).setAlias(temp);
                }

                else if (nInput == 3){
                    System.out.println("1 - Free");
                    System.out.println("2 - Captured");
                    System.out.println("3 - Dead");
                    System.out.print("Enter your character's status index: ");
                    nInput = myObj.nextInt();
                    buffer = myObj.nextLine();

                    if (nInput == 1){
                        temp = "Free";
                        characterRegistry.get(nChar-1).setStatus(temp);
                    }

                    else if (nInput == 2){
                        temp = "Captured";
                        characterRegistry.get(nChar-1).setStatus(temp);
                    }

                    else if (nInput == 3){
                        temp = "Dead";
                        characterRegistry.get(nChar-1).setStatus(temp);
                    }

                    else{
                        System.out.println("Please enter a valid index!");
                    }
                }

                else if (nInput == 4){
                    System.out.print("Enter your character's new origin: ");
                    temp = myObj.nextLine();
                    characterRegistry.get(nChar-1).setOrigin(temp);
                }

                else{
                    System.out.print("Enter your character's new wallet balance: ");
                    tempDouble = myObj.nextDouble();
                    characterRegistry.get(nChar-1).setWallet(tempDouble);
                }
            }

            else if (nInput == 6){
                if (characterRegistry.get(nChar-1) instanceof Pirate){
                    System.out.print("Enter your character's new bounty: ");
                    tempDouble = myObj.nextDouble();
                    ((Pirate) characterRegistry.get(nChar-1)).assignBounty(tempDouble);
                }

                else if (characterRegistry.get(nChar-1) instanceof Marine){
                    System.out.print("Enter your character's new rank: ");
                    temp = myObj.nextLine();
                    ((Marine) characterRegistry.get(nChar-1)).promoteRank(temp);
                }

                else if (characterRegistry.get(nChar-1) instanceof Civilian){
                    System.out.print("Enter your character's new profession: ");
                    temp = myObj.nextLine();
                    ((Civilian) characterRegistry.get(nChar-1)).setProfession(temp);
                }

                else if (characterRegistry.get(nChar-1) instanceof PirateHunter){
                    System.out.print("Enter your character's new combat style: ");
                    temp = myObj.nextLine();
                    ((PirateHunter) characterRegistry.get(nChar-1)).
                            setCombatStyle(temp);
                }
            }

            else if (nInput == 7){
                if (characterRegistry.get(nChar-1) instanceof Pirate){
                    System.out.print("Enter your character's new role: ");
                    temp = myObj.nextLine();
                    ((Pirate) characterRegistry.get(nChar-1)).setRole(temp, myObj);
                }

                else if (characterRegistry.get(nChar-1) instanceof Civilian){
                    System.out.print("Enter your character's new residence: ");
                    temp = myObj.nextLine();
                    ((Civilian) characterRegistry.get(nChar-1)).setResidence(temp);
                }

                else if (characterRegistry.get(nChar-1) instanceof PirateHunter){
                    System.out.print("Enter your character's new confirmed capture count: ");
                    tempInt = myObj.nextInt();
                    ((PirateHunter) characterRegistry.get(nChar-1)).
                            setConfirmedCaptures(tempInt);
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }

            else{
                System.out.println("Please enter a valid index!");
            }

            
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method displays all registered characters if there are any.
     *         Parameters : None
     *         Returns : void
     */
    private static void displayCharacters(){
        int index = 1;

        if (!characterRegistry.isEmpty()){
            System.out.println("--CHARACTER REGISTRY--");
            for (Character c: characterRegistry){
                System.out.println(index + ". " +
                        characterRegistry.get(index - 1).getName() +
                        " (" + characterRegistry.get(index - 1).getClass().getSimpleName()
                        + ")");
                index++;
            }
        }

        else{
            System.out.println("There are no characters in the registry!");
        }
    }

    /**
     * This method serves as a menu for the character database.
     *         Parameters : None
     *         Returns : void
     */
    private static void characterDatabase(){
        int nInput;
        boolean isRunning;
        String buffer;

        isRunning = true;
        while (isRunning){
            System.out.println("Character Database");
            System.out.println("1 - Add a new character");
            System.out.println("2 - View a character");
            System.out.println("3 - Modify a character");
            System.out.println("4 - Delete a character");
            System.out.println("5 - Exit menu");
            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput == 1){
                addCharacter();
            }

            else if (nInput == 2){
                displayCharacters();
                System.out.print("Enter your choice: ");
                nInput = myObj.nextInt();
                buffer = myObj.nextLine();

                if (nInput >= 1 && nInput <= characterRegistry.size()){
                    characterRegistry.get(nInput -1).displayProfile();
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }

            else if (nInput == 3){
                modifyCharacter();
            }

            else if (nInput == 4){
                displayCharacters();
                System.out.print("Enter your choice: ");
                nInput = myObj.nextInt();
                buffer = myObj.nextLine();

                if (nInput >= 1 && nInput <= characterRegistry.size()){
                    System.out.println("You have removed " +
                            characterRegistry.get(nInput-1).getName() +
                            " from the character registry.");
                    characterRegistry.remove(nInput-1);
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }

            else if (nInput == 5){
                isRunning = false;
            }
        }
    }

    /**
     * This method serves as a menu for affiliation creation.
     *         Parameters : None
     *         Returns : void
     */
    private static void addAffiliation(){
        int nInput;
        String buffer;

        System.out.println("1 - Pirate Crew");
        System.out.println("2 - Marine Corps");
        System.out.print("Enter your affiliation's type index: ");
        nInput = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nInput == 1){
            createCrew();
        }

        else if (nInput == 2){
            createCorps();
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method displays all registered affiliations if there are any.
     *         It also gives users the options to view the profiles of affiliation members.
     *         Parameters : None
     *         Returns : void
     */
    private static void viewGroups(){
        int nAff, nMember;
        boolean isRunning;
        String buffer;

        displayAffiliations();
        System.out.print("Enter your choice: ");
        nAff = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nAff >= 1 && nAff <= affiliationRegistry.size()){
            isRunning = true;
            while (isRunning){
                affiliationRegistry.get(nAff -1).displayAttributes();
                affiliationRegistry.get(nAff -1).displayMembers();
                System.out.println("Would you like to view a profile?");
                System.out.println("(Enter the profile index if yes and 0 if no)");
                System.out.print("Enter your choice: ");
                nMember = myObj.nextInt();
                buffer = myObj.nextLine();

                if (nMember == 0){
                    isRunning = false;
                }

                else if (nMember >= 1 && nMember <=
                        affiliationRegistry.get(nAff-1).affiliationRoster.size()){
                    System.out.println();
                    affiliationRegistry.get(nAff-1).
                            affiliationRoster.get(nMember-1).displayProfile();
                    System.out.println();
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method serves as a menu for pirate crew creation.
     *         Parameters : None
     *         Returns : void
     */
    private static void createCrew(){
        String crew, ship;
        String buffer;

        System.out.print("Enter your crew's name: ");
        crew = myObj.nextLine();

        System.out.print("Enter your crew's ship name: ");
        ship = myObj.nextLine();

        PirateCrew temp = new PirateCrew(crew, ship,
                ++affiliationCount);
        registerCrewRegistry(temp);
    }

    /**
     * This method registers crews into the registry.
     *         Returns : void
     *
     * @param c the pirate crew being registered
     */
    private static void registerCrewRegistry(PirateCrew c){
        affiliationRegistry.add(c);
        System.out.println(c.getName() + " has been successfully added to the "
        + " affiliation registry!");
    }

    /**
     * This method serves as a menu for marine corps creation.
     *        Parameters : None
     *        Returns : void
     */
    private static void createCorps(){
        String base;
        double funds;
        String buffer;

        System.out.print("Enter your corps' base location: ");
        base = myObj.nextLine();

        System.out.print("Enter your corps' operational funds: ");
        funds = myObj.nextDouble();
        buffer = myObj.nextLine();

        MarineCorps temp = new MarineCorps(base, funds,
                ++affiliationCount);
        registerCorpsRegistry(temp);
    }

    /**
     * This method registers corps units into the registry.
     *          Returns : void
     *
     * @param c the corps unit being registered
     */
    private static void registerCorpsRegistry(MarineCorps c){
        affiliationRegistry.add(c);
        System.out.println(c.getName() + " has been successfully added to the "
                + " affiliation registry!");
    }

    /**
     * This method serves as a menu for affiliation modification.
     *         Parameters : None
     *         Returns : void
     */
    private static void modifyAffiliation(){
        int nAff, nInput, tempInt;
        double tempDouble;
        String temp;
        String buffer;

        displayAffiliations();
        System.out.print("Enter your affiliation's index: ");
        nAff = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nAff >= 1 && nAff <= affiliationRegistry.size()){
            affiliationRegistry.get(nAff-1).displayAttributes();

            if (affiliationRegistry.get(nAff-1) instanceof PirateCrew){
                System.out.println("1 - Crew Name");
                System.out.println("2 - Ship Name");
            }

            else if (affiliationRegistry.get(nAff-1) instanceof MarineCorps){
                System.out.println("1 - Base Location");
                System.out.println("2 - Corps Commander");
            }

            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (affiliationRegistry.get(nAff-1) instanceof PirateCrew){
                if (nInput == 1){
                    System.out.print("Enter your crew's new name: ");
                    temp = myObj.nextLine();
                    ((PirateCrew) affiliationRegistry.get(nAff-1)).setCrewName(temp);
                }

                else if (nInput == 2){
                    System.out.print("Enter your crew's new ship name: ");
                    temp = myObj.nextLine();
                    ((PirateCrew) affiliationRegistry.get(nAff-1)).setShipName(temp);
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }

            else if (affiliationRegistry.get(nAff-1) instanceof MarineCorps){
                if (nInput == 1){
                    System.out.print("Enter your corps unit's new base location: ");
                    temp = myObj.nextLine();
                    ((MarineCorps) affiliationRegistry.get(nAff-1)).
                            setBaseLocation(temp);
                }

                else if (nInput == 2){
                    affiliationRegistry.get(nAff-1).displayMembers();
                    System.out.print("Enter your new commander's index: ");
                    tempInt = myObj.nextInt();
                    ((MarineCorps) affiliationRegistry.get(nAff-1)).
                            setCorpsCommander(affiliationRegistry.get(nAff-1).
                                    affiliationRoster.get(tempInt-1), myObj);
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method displays all registered affiliations if there are any.
     *         Parameters : None
     *         Returns : void
     */
    private static void displayAffiliations(){
        int index = 1;

        if (!affiliationRegistry.isEmpty()){
            System.out.println("--AFFILIATION REGISTRY--");
            for (Affiliation a: affiliationRegistry){
                System.out.println(index + ". " +
                        affiliationRegistry.get(index - 1).getName());
                index++;
            }
        }

        else{
            System.out.println("There are no affiliations in the registry!");
        }
    }

    /**
     * This method serves as a menu for adding members to an affiliation.
     *         Parameters : None
     *         Returns : void
     */
    private static void addMemberToAffiliation(){
        int nAff, nMember;
        String buffer;

        displayAffiliations();
        System.out.print("Enter your choice: ");
        nAff = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nAff >= 1 && nAff <= affiliationRegistry.size()){
            displayCharacters();
            System.out.print("Enter your choice: ");
            nMember = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nMember >= 1 && nMember <= characterRegistry.size()){
                affiliationRegistry.get(nAff-1).groupOperations(1,
                        characterRegistry.get(nMember-1), myObj);
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method serves as a menu for removing members from an affiliation.
     *         Parameters : None
     *         Returns : void
     */
    private static void removeMemberFromAffiliation(){
        int nAff, nMember;
        String buffer;

        displayAffiliations();
        System.out.print("Enter your choice: ");
        nAff = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nAff >= 1 && nAff <= affiliationRegistry.size()){
            affiliationRegistry.get(nAff-1).displayMembers();
            System.out.print("Enter your choice: ");
            nMember = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nMember >= 1 &&
                    nMember <= affiliationRegistry.get(nAff-1).
                            affiliationRoster.size()){
                affiliationRegistry.get(nAff-1).groupOperations(2,
                        affiliationRegistry.get(nAff-1).
                                affiliationRoster.get(nMember-1), myObj);
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method serves as a menu for the affiliation database.
     *         Parameters : None
     *         Returns : void
     */
    private static void affiliationDatabase(){
        int nInput, nAff;
        boolean isRunning;
        String buffer;

        isRunning = true;
        while (isRunning){
            System.out.println("Affiliation Database");
            System.out.println("1 - Create Group");
            System.out.println("2 - View Groups");
            System.out.println("3 - Edit group attributes");
            System.out.println("4 - Add members");
            System.out.println("5 - Remove members");
            System.out.println("6 - Exit menu");
            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput == 1){
                addAffiliation();
            }

            else if (nInput == 2){
                viewGroups();
            }

            else if (nInput == 3){
                modifyAffiliation();
            }

            else if (nInput == 4){
                addMemberToAffiliation();
            }

            else if (nInput == 5){
                removeMemberFromAffiliation();
            }

            else if (nInput == 6){
                isRunning = false;
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }
    }

    /**
     * This method serves as a menu for devil fruit creation.
     *             Parameters : None
     *             Returns : void
     */
    private static void addDevilFruit(){
        String name, category, ability;
        String buffer;

        System.out.print("Enter your devil fruit's name: ");
        name = myObj.nextLine();

        System.out.print("Enter your devil fruit's category: ");
        category = myObj.nextLine();

        System.out.print("Enter your devil fruit's primary ability: ");
        ability = myObj.nextLine();

        DevilFruit temp = new DevilFruit(name, category, ability,
                ++devilFruitCount);
        devilFruitRegistry.add(temp);
    }

    /**
     * This method displays all registered devil fruits if there are any.
     *         Parameters : None
     *         Returns : void
     */
    private static void displayDevilFruits(){
        int index = 1;

        if (!devilFruitRegistry.isEmpty()){
            System.out.println("--DEVIL FRUIT REGISTRY--");
            for (DevilFruit d: devilFruitRegistry){
                System.out.println(index + ". " +
                        devilFruitRegistry.get(index - 1).getFruitName());
                index++;
            }
        }

        else{
            System.out.println("There are no devil fruits in the registry!");
        }
    }

    /**
     * This method serves as a menu for devil fruit assignment.
     *             Parameters : None
     *             Returns : void
     */
    private static void assignDevilFruit(){
        int nFruit, nCharacter;
        String buffer;

        displayDevilFruits();
        System.out.print("Enter your devil fruit's index: ");
        nFruit = myObj.nextInt();
        buffer = myObj.nextLine();

        if (nFruit >= 1 && nFruit <= devilFruitRegistry.size()){
            displayCharacters();
            System.out.print("Enter your character's index: ");
            nCharacter = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nCharacter >= 1 && nCharacter <= characterRegistry.size()){
                devilFruitRegistry.get(nFruit-1).
                        assignToNewUser(characterRegistry.get(nCharacter-1));
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }

        else{
            System.out.println("Please enter a valid index!");
        }
    }

    /**
     * This method serves as a menu for the devil fruit database.
     *         Parameters : None
     *         Returns : void
     */
    private static void devilFruitDatabase(){
        int nInput;
        boolean isRunning;
        String buffer;

        isRunning = true;
        while (isRunning) {
            System.out.println("Devil Fruit Database");
            System.out.println("1 - Create a devil fruit");
            System.out.println("2 - View devil fruit");
            System.out.println("3 - Assign to a new user");
            System.out.println("4 - Exit menu");
            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput == 1){
                addDevilFruit();
            }

            else if (nInput == 2){
                displayDevilFruits();
                System.out.print("Enter your choice: ");
                nInput = myObj.nextInt();
                buffer = myObj.nextLine();

                if (nInput >= 1 && nInput <= devilFruitRegistry.size()){
                    devilFruitRegistry.get(nInput -1).displayProfile();
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }

            else if (nInput == 3){
                assignDevilFruit();
            }

            else if (nInput == 4){
                isRunning = false;
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }
    }

    private static void registerCapture(){
        int captor, captured, captureStatus;
        boolean isRunning;
        String buffer;

        displayCharacters();
        System.out.print("Enter your captor's index: ");
        captor = myObj.nextInt();
        buffer = myObj.nextLine();

        if (captor >= 1 && captor <= characterRegistry.size()){
            displayCharacters();
            System.out.print("Enter your captured's index: ");
            captured = myObj.nextInt();
            buffer = myObj.nextLine();

            if (captured >= 1 && captured <= characterRegistry.size()){
                isRunning = true;
                while (isRunning){
                    System.out.println("1 - Alive");
                    System.out.println("2 - Dead");
                    System.out.print("Enter your choice's index: ");
                    captureStatus = myObj.nextInt();
                    buffer = myObj.nextLine();

                    if (captureStatus >= 1 && captureStatus <= 2){
                        if (validateCaptor(characterRegistry.get(captor-1),
                                characterRegistry.get(captured-1))){
                            Capture temp = new Capture(characterRegistry.get(captor-1),
                                    characterRegistry.get(captured-1),
                                    captureStatus,
                                    ++captureCount);
                            logTransaction(temp);
                        }

                        isRunning = false;
                    }

                    else{
                        System.out.println("Please enter a valid index!");
                    }
                }
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }

        else{
            System.out.println("Please enter a valid index!");
        }

    }

    private static boolean validateCaptor(Character captor, Character captured){
        if (!(captor instanceof Pirate)){
            if (captured instanceof Pirate &&
                    captured.getStatus().equalsIgnoreCase("Free")){
                return true;
            }

            else{
                System.out.println("Error: The captured must be a free pirate!");
                return false;
            }
        }

        else{
            System.out.println("Error: The captor cannot be a pirate!");
            return false;
        }
    }

    private static void logTransaction(Capture temp){
        captureRegistry.add(temp);
    }

    private static void viewHistoricalCaptures(){
        int index = 1;

        if (!captureRegistry.isEmpty()){
            for (Capture c : captureRegistry){
                System.out.println("--CAPTURE HISTORY--");
                System.out.println(index + ". " +
                        captureRegistry.get(index - 1).getCaptor().getName() +
                        "'s capture of " +
                        captureRegistry.get(index - 1).getCapturedPirate()
                        .getName());
                index++;
            }
        }

        else{
            System.out.println("No captures have been recorded yet!");
        }

    }

    private static void bountySystemDatabase(){
        int nInput;
        boolean isRunning;
        String buffer;

        isRunning = true;
        while (isRunning) {
            System.out.println("Bounty System Database");
            System.out.println("1 - Register a Capture");
            System.out.println("2 - View historical captures");
            System.out.println("3 - Exit menu");
            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput == 1){
                registerCapture();
            }

            else if (nInput == 2){
                viewHistoricalCaptures();
            }

            else if (nInput == 3){
                isRunning = false;
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }
    }

    public static void main(String[] args){
        int nInput;
        boolean isRunning;
        String buffer;

        //test characters
        characterRegistry.add(new Pirate("Johnny Tack",
                "Bolsa", "Belgium", "Free",
                ++characterCount, 1000));
        characterRegistry.add(new Pirate("Mister Smee",
                "Smee", "Poland", "Free",
                ++characterCount, 2000));
        characterRegistry.add(new Pirate("Benjamin Net",
                "Old Benny", "Tel Aviv", "Free",
                ++characterCount, 3000));
        characterRegistry.add(new Pirate("Ted",
                "Old Benny", "Tel Aviv", "Captured",
                ++characterCount, 3000));
        characterRegistry.add(new Pirate("Mr. Bean",
                "Old Benny", "Tel Aviv", "Dead",
                ++characterCount, 3000));

        characterRegistry.add(new Marine("Seamen King",
                "SeamenKing", "Finland", "Free",
                ++characterCount, "Admiral"));

        // test affiliations
        affiliationRegistry.add(new PirateCrew("Crew Alex",
                "St. Alice", ++affiliationCount));
        affiliationRegistry.add(new PirateCrew("Crew Brian",
                "The Big Jonathan", ++affiliationCount));
        affiliationRegistry.add(new MarineCorps("Corps Brown",
                10000, ++affiliationCount));
        affiliationRegistry.add(new MarineCorps("Corps White",
                30000, ++affiliationCount));

        // test devil fruits
        devilFruitRegistry.add(new DevilFruit("Apple", "Regular",
                "Keeps the doctor away", ++devilFruitCount));
        devilFruitRegistry.add(new DevilFruit("Orange", "Regular",
                "Boosts attack", ++devilFruitCount));
        devilFruitRegistry.add(new DevilFruit("Broccoli", "Special",
                "Boosts fortitude", ++devilFruitCount));

        isRunning = true;
        while (isRunning){
            System.out.println("Main Menu");
            System.out.println("1 - Character Database");
            System.out.println("2 - Affiliation Database");
            System.out.println("3 - Devil Fruit Database");
            System.out.println("4 - Bounty System");
            System.out.println("5 - Exit program");
            System.out.print("Enter your choice: ");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput == 1){
                characterDatabase();
            }

            else if (nInput == 2){
                affiliationDatabase();
            }

            else if (nInput == 3){
                devilFruitDatabase();
            }

            else if (nInput == 4){
                bountySystemDatabase();
            }

            else if (nInput == 5){
                isRunning = false;
                System.out.println("Program has been terminated. Farewell!");
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }

    }
}
