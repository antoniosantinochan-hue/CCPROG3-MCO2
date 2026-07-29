package databaseModel;
/**
 * This is the Civilian class. It inherits from the Character class.
 */
public class Civilian extends Character{
    private String profession;
    private String residence;


    /**
     * This method is the Civilian class constructor.
     *          Returns : None
     * @param pName name of the pirate hunter
     * @param pAlias alias of the pirate hunter
     * @param pOrigin origin of the pirate hunter
     * @param pStatus status of the pirate hunter
     * @param pID ID of the pirate hunter
     * @param pProfession profession of the pirate hunter
     * @param pResidence residence of the pirate hunter
     */
    public Civilian(String pName, String pAlias, String pOrigin,
                 String pStatus, int pID, String pProfession,
             String pResidence){
        super(pName, pAlias, pOrigin, pStatus, pID);
        this.profession = pProfession;
        this.residence = pResidence;
    }

    /**
     * This method displays the profile of a civilian.
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
        System.out.println("Profession: " + this.profession);
        System.out.println("Residence: " + this.residence);
        System.out.println("-----------------------------");
    }

    /**
     * This method sets the profession of a civilian.
     *         Returns : void
     * @param profession inputted profession of marine
     */
    public void setProfession(String profession){
        this.profession = profession;
    }

    /**
     * This method sets the residence of a civilian.
     *         Returns : void
     * @param residence inputted residence of marine
     */
    public void setResidence(String residence){
        this.residence = residence;
    }
}
