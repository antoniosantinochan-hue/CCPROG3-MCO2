package databaseModel;

/**
 * This is the Character class. It is an abstract class.
 */
public abstract class Character {
    private final int CHARACTER_ID;
    private String name;
    private String alias;
    private String origin;
    private String status;
    private DevilFruit devilFruitPower;
    private double wallet;


    /**
     * This method is the Character class constructor.
     *         Returns : None
     *
     * @param pName name of the character
     * @param pAlias alias of the character
     * @param pOrigin origin of the character
     * @param pStatus status of the character
     * @param pID ID of the character
     */
    Character(String pName, String pAlias, String pOrigin,
                     String pStatus, int pID){
        this.CHARACTER_ID = pID;
        this.name = pName;
        this.alias = pAlias;
        this.origin = pOrigin;
        this.status = pStatus;
        this.devilFruitPower = null;
        this.wallet = 0;
    }

    /**
     * This method displays the profile of a character.
     *         Parameters : None
     *         Returns : void
     */
    public abstract void displayProfile();

    /**
     * This method returns the id of the character object.
     *         Parameters : None
     *         Returns :
     *         CHARACTER_ID - id of character object
     *
     * @return the id of character object
     */
    public int getCHARACTER_ID(){
        return CHARACTER_ID;
    }

    /**
     * This method returns the name of the character object.
     *         Parameters : None
     *         Returns :
     *         this.name - name of character object
     * @return name of character object
     */
    public String getName(){
        return this.name;
    }

    /**
     * This method returns the alias of the character object.
     *         Parameters : None
     *         Returns :
     *         this.alias - alias of character object
     * @return alias of character object
     */
    public String getAlias(){
        return this.alias;
    }

    /**
     * This method returns the origin of the character object.
     *         Parameters : None
     *         Returns :
     *         this.origin - origin of character object
     * @return origin of character object
     */
    public String getOrigin(){
        return this.origin;
    }

    /**
     * This method returns the status of the character object.
     *         Parameters : None
     *         Returns :
     *         this.status - status of character object
     * @return status of character object
     */
    public String getStatus(){
        return this.status;
    }

    /**
     * This method returns the devil fruit power of the character object.
     *         Parameters : None
     *         Returns :
     *         this.devilFruitPower - devil fruit power of character object
     * @return devil fruit power of character object
     */
    public DevilFruit getDevilFruitPower(){
        return devilFruitPower;
    }

    /**
     * This method returns the wallet balance of the character object.
     *         Parameters : None
     *         Returns :
     *         this.wallet - wallet balance of character object
     * @return wallet balance of character object
     */
    public double getWallet(){
        return this.wallet;
    }

    /**
     * This method sets the name of the character object.
     *         Returns : void
     * @param name inputted name of the character object
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * This method sets the alias of the character object.
     *         Returns : void
     * @param alias inputted alias of character object
     */
    public void setAlias(String alias){ this.alias = alias;}

    /**
     * This method sets the status of the character object.
     *         Returns : void
     * @param status inputted status of character object
     */
    public void setStatus(String status){
        if (status.equalsIgnoreCase("Dead") &&
                (this.devilFruitPower != null)){
            this.devilFruitPower.triggerReincarnation();
            setDevilFruitPower(null);
        }
        this.status = status;
    }

    /**
     * This method sets the origin of the character object.
     *         Returns : void
     * @param origin inputted origin of character object
     */
    public void setOrigin(String origin){ this.origin = origin;}

    /**
     * This method sets the wallet balance of the character object.
     *         Returns : void
     * @param wallet inputted balance of character object
     */
    public void setWallet(double wallet){
        if (wallet >= 0){
            this.wallet = wallet;
        }
        else{
            System.out.println("Please enter a valid input!");
            System.out.println("Wallet value set to be 0.");
            this.wallet = 0;
        }
    }

    /**
     * This method sets the devil fruit power of the character object.
     *         Returns : void
     * @param d inputted devil fruit power of character object
     */
    public void setDevilFruitPower(DevilFruit d){
        this.devilFruitPower = d;
    }
}
