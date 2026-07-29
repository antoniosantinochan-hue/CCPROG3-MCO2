package databaseModel;
import java.util.*;

/**
 * This is the Marine class. It inherits from the Character class.
 */
public class Marine extends Character{
    private String rank;
    private MarineCorps marineCorps;

    /**
     * This method is the Marine class constructor.
     *          Returns : None
     * @param pName name of the marine
     * @param pAlias alias of the marine
     * @param pOrigin origin of the marine
     * @param pStatus status of the marine
     * @param pID ID of the marine
     * @param pRank rank of the marine
     */
    public Marine(String pName, String pAlias, String pOrigin,
           String pStatus, int pID, String pRank){
        super(pName, pAlias, pOrigin, pStatus, pID);
        this.rank = pRank;
    }

    /**
     * This method changes the marine's rank.
     *         Returns : void
     * @param rank inputted rank for marine
     */
    public void promoteRank(String rank){
        this.rank = rank;
    }


    /**
     * This method assigns a marine to a corps unit.
     *         Returns : void
     * @param c inputted corps unit for marine
     */
    public void assignToCorps(MarineCorps c){
        this.marineCorps = c;
    }

    /**
     * This method removes a marine from a corps unit.
     *         Parameters : None
     *         Returns : void
     */
    public void removeFromCorps(){
        assignToCorps(null);
    }

    /**
     * This method displays the profile of a marine.
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
        System.out.println("Rank: " + this.rank);
        if (this.marineCorps == null){
            System.out.println("Marine Corps Unit: null");
        }
        else{
            System.out.println("Marine Corps Unit: " + this.marineCorps.getName());
        }
        System.out.println("-----------------------------");
    }

    /**
     * This method returns the rank of the marine object.
     *         Parameters : None
     *         Returns :
     *         this.rank - rank of marine object
     * @return rank of marine object
     */
    public String getRank(){
        return this.rank;
    }

    /**
     *This method returns the corps unit of the marine object.
     *         Parameters : None
     *         Returns :
     *         this.marineCorps - corps unit of marine object
     * @return corps unit of marine object
     */
    public MarineCorps getMarineCorps(){ return this.marineCorps;}
}
