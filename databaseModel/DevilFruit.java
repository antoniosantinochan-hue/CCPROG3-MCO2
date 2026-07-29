package databaseModel;
import java.util.ArrayList;

/**
 * This is the DevilFruit class.
 */
public class DevilFruit {
    private final int FRUIT_ID;
    private String fruitName;
    private String category;
    private String primaryAbility;
    private boolean isAvailable;
    private Character currentOwner;
    private ArrayList<Character> historicalOwners = new ArrayList<>();


    /**
     * This method is the DevilFruit class constructor.
     *         Returns : None
     * @param pFruit fruit name of the devil fruit
     * @param pCategory category of the devil fruit
     * @param pPrimaryAb primary ability of the devil fruit
     * @param pID ID of the devil fruit
     */
    public DevilFruit(String pFruit, String pCategory, String pPrimaryAb,
               int pID){
        FRUIT_ID = pID;
        fruitName = pFruit;
        category = pCategory;
        primaryAbility = pPrimaryAb;
        isAvailable = true;
    }

    /**
     * This method assigns a devil fruit to a new user.
     *        Returns : void
     * @param c inputted character assigned to the devil fruit
     */
    public void assignToNewUser(Character c){
        if (isAvailable && (c.getDevilFruitPower() == null)){
            c.setDevilFruitPower(this);
            this.currentOwner = c;
            this.isAvailable = false;
        }
        else if (isAvailable && (c.getDevilFruitPower() != null)){
            System.out.println("This character already has a devil fruit power!");
        }

        else{
            System.out.println("This devil fruit is unavailable!");
        }
    }

    /**
     * This method adds the current owner to the list of historical owners
     *       after the current owner becomes deceased. It also makes the devil fruit
     *       available for assignment.
     *       Parameters : None
     *       Returns : void
     */
    public void triggerReincarnation(){
        this.historicalOwners.add(currentOwner);
        this.currentOwner = null;
        this.isAvailable = true;
    }

    /**
     * This method displays the profile of a devil fruit.
     *       Parameters : None
     *       Returns : void
     */
    public void displayProfile(){
        System.out.println("-----------------------------");
        System.out.printf("Fruit ID: %09d\n", this.FRUIT_ID);
        System.out.println("Fruit Name: " + this.fruitName);
        System.out.println("Category: " + this.category);
        System.out.println("Primary Ability: " + this.primaryAbility);
        if (this.currentOwner == null){
            System.out.println("Current Owner: null");
        }
        else{
            System.out.println("Current Owner: " + this.currentOwner.getName());
        }

        System.out.println("Historical Users: ");
        int index = 1;
        for (Character c: historicalOwners){
            System.out.println(index + ". " + c.getName());
            index++;
        }
        System.out.println("-----------------------------");
    }


    /**
     * This method returns the name of the devil fruit object.
     *       Parameters : None
     *       Returns :
     *       this.fruitName - the fruit name of the devil fruit object
     *
     * @return the fruit name of the devil fruit object
     */
    public String getFruitName(){return this.fruitName;}

    /**
     * This method returns the category of the devil fruit object.
     *       Parameters : None
     *       Returns :
     *       this.category - the category of the devil fruit object
     * @return the category of the devil fruit object
     */
    public String getCategory(){return this.category;}

    /**
     * This method returns the primary ability of the devil fruit object.
     *       Parameters : None
     *       Returns :
     *       this.primaryAbility - the primary ability of the devil fruit object
     * @return the primary ability of the devil fruit object
     */
    public String getPrimaryAbility(){return this.primaryAbility;}
}
