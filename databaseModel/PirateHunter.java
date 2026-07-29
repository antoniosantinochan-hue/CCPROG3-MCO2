package databaseModel;
/**
 * This is the Pirate Hunter class. It inherits from the Character class.
 */
public class PirateHunter extends Character{
    private String combatStyle;
    private int confirmedCaptures;

    /**
     * This method is the PirateHunter class constructor.
     *          Returns : None
     * @param pName name of the pirate hunter
     * @param pAlias alias of the pirate hunter
     * @param pOrigin origin of the pirate hunter
     * @param pStatus status of the pirate hunter
     * @param pID ID of the pirate hunter
     * @param pStyle combat style of the pirate hunter
     * @param nCount capture count of the pirate hunter
     */
    public PirateHunter(String pName, String pAlias, String pOrigin,
           String pStatus, int pID, String pStyle, int nCount){
        super(pName, pAlias, pOrigin, pStatus, pID);
        this.combatStyle = pStyle;
        this.confirmedCaptures = nCount;
    }

    /**
     * This method displays the profile of a pirate hunter.
     *         Parameters : None
     *         Returns : void
     */
    public void displayProfile(){
        System.out.println("-----------------------------");
        System.out.printf("Character ID: %07d\n", super.getCHARACTER_ID());
        System.out.println("Name: " + super.getName());
        System.out.println("Alias: " + super.getAlias());
        System.out.println("Origin: " + super.getOrigin());
        System.out.println("Status: " + super.getStatus());
        if (super.getDevilFruitPower() == null){
            System.out.println("Devil Fruit Power: null");
        }
        else{
            System.out.println("Devil Fruit Power: " +
                    super.getDevilFruitPower().getFruitName());
        }
        System.out.println("Wallet: " + super.getWallet());
        System.out.println("Combat Style: " + this.combatStyle);
        System.out.println("Confirmed Captures: " + this.confirmedCaptures);
        System.out.println("-----------------------------");
    }

    /**
     * This method sets the combat style of a pirate hunter.
     *         Returns : void
     * @param combatStyle inputted combat style of pirate hunter
     */
    public void setCombatStyle(String combatStyle){
        this.combatStyle = combatStyle;
    }

    /**
     * This method sets the capture count of a pirate hunter.
     *         Returns : void
     * @param captures inputted capture count of pirate hunter
     */
    public void setConfirmedCaptures(int captures){
        this.confirmedCaptures = captures;
    }
}
