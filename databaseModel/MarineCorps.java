package databaseModel;
import java.util.*;

/**
 * This is the MarineCorps class. It inherits from the Affiliation class.
 */
public class MarineCorps extends Affiliation{

    private final int CORPS_ID;
    private String baseLocation;
    private Character corpsCommander;
    private boolean hasCorpsCommander;
    private double operationalFunds;

    /**
     * This method is the MarineCorps class constructor.
     *             Returns : None
     * @param pBase base location of the corps unit
     * @param pFunds name of the ship
     * @param pID ID of the corps unit
     */
    public MarineCorps(String pBase, double pFunds, int pID){
        this.CORPS_ID = pID;
        this.baseLocation = pBase;
        this.operationalFunds = pFunds;
        this.hasCorpsCommander = false;
    }

    /**
     * This method serves as a menu for the corps unit's group operations.
     *         Returns : None
     * @param operation index of the chosen operation
     *         (1 for adding members, 2 for removing)
     * @param c marine to be modified
     * @param myObj scanner object from main
     */
    public void groupOperations(int operation, Character c, Scanner myObj){
        if (operation == 1){
            if (c instanceof Marine && (((Marine) c).getMarineCorps() == null)){
                affiliationRoster.add(c);
                ((Marine) c).assignToCorps(this);
                System.out.println(c.getName() + " has joined " + this.getName() +
                        " as a " + ((Marine) c).getRank() + "!");
            }

            else if (c instanceof Marine && (((Marine) c).getMarineCorps() != null)){
                System.out.println("This character is already in a corps unit!");
            }

            else{
                System.out.println("This character is not a marine!");
            }
        }

        else if (operation == 2){
            System.out.println(c.getName() + " has been removed from " +
                    this.getName() + " as a " + ((Marine) c).getRank());

            if (c == this.corpsCommander){
                this.hasCorpsCommander = false;
            }
            affiliationRoster.remove(c);
            ((Marine) c).removeFromCorps();

        }
    }

    /**
     * This method returns the base location of the corps unit object.
     *        Parameters : None
     *        Returns :
     *        baseLocation - base location of the pirate crew object
     * @return base location of the pirate crew object
     */
    public String getName(){
        return baseLocation;
    }

    /**
     * This method displays the members of the corps unit.
     *         Parameters : None
     *         Returns : None
     */
    public void displayMembers(){
        int index = 1;

        if (!affiliationRoster.isEmpty()){
            for (Character p : affiliationRoster) {
                System.out.println(index + ". " + p.getName());
                index++;
            }
        }

        else{
            System.out.println("This corps unit has no members.");
        }
    }

    /**
     * This method displays the attributes of the corps unit.
     *         Parameters : None
     *         Returns : None
     */
    public void displayAttributes(){
        System.out.println("-----------------------------");
        System.out.printf("Corps ID: %07d\n", this.CORPS_ID);
        System.out.println("Base Location: " + this.baseLocation);
        if (this.corpsCommander == null){
            System.out.println("Corps Commander: null");
        }
        else{
            System.out.println("Corps Commander: " + this.corpsCommander.getName());
        }
        System.out.println("Corps Unit Members: ");
        displayMembers();
        System.out.println("Operational Funds: " + this.operationalFunds);
        System.out.println("-----------------------------");
    }

    /**
     * This method sets the base location of the corps unit object.
     *        Returns : None
     * @param base inputted base location of the corps unit object
     */
    public void setBaseLocation(String base){
        this.baseLocation = base;
    }

    /**
     *This method sets the corps commander of the corps unit object.
     *        Returns : None
     * @param c inputted corps commander of the corps unit object
     * @param myObj scanner object from main
     */
    public void setCorpsCommander(Character c, Scanner myObj){
        int nInput;
        String buffer;

        if (!this.hasCorpsCommander){
            this.corpsCommander = c;
            this.hasCorpsCommander = true;
            System.out.println(c.getName() + " is the new corps commander!");
        }

        else{
            System.out.println("This corps unit already has a commander. Change?");
            System.out.println("1 - Yes");
            System.out.println("Any other integer - No");
            nInput = myObj.nextInt();

            if (nInput == 1){
                this.corpsCommander = c;
                System.out.println(c.getName() + " is the new corps commander!");
            }
        }
    }
}
