package databaseModel;
import java.util.Scanner;

/**
 * This is the Pirate class. It inherits from the Character class.
 */
public class Pirate extends Character{
    private double bounty;
    private String role;
    private boolean isCaptain;
    private PirateCrew pirateCrew;


    /**
     * This method is the Pirate class constructor.
     *         Returns : None
     * @param pName name of the pirate
     * @param pAlias alias of the pirate
     * @param pOrigin origin of the pirate
     * @param pStatus status of the pirate
     * @param pID ID of the pirate
     * @param pBounty bounty of the pirate
     */
    public Pirate(String pName, String pAlias, String pOrigin,
           String pStatus, int pID, double pBounty){
        super(pName, pAlias, pOrigin, pStatus, pID);

        if (pBounty >= 0){
            this.bounty = pBounty;
        }
        else{
            this.bounty = 0;
        }
    }

    /**
     *This method assigns a bounty to a pirate.
     *         Returns : void
     * @param fInput inputted bounty for pirate
     */
    public void assignBounty(double fInput){
        if (fInput >= 0){
            this.bounty = fInput;
            System.out.println(super.getName() + "'s bounty has been changed to " +
                    this.bounty);
        }
        else{
            System.out.println("Please enter a valid input!");
        }
    }

    /**
     * This method assigns a pirate to a crew.
     *         Returns : void
     * @param c inputted pirate crew for pirate
     */
    public void assignToCrew(PirateCrew c){
        this.pirateCrew = c;
    }


    /**
     * This method removes a pirate from a crew.
     *         Parameters : None
     *         Returns : void
     */
    public void removeFromCrew(){
        assignToCrew(null);
        this.role = null;
        this.isCaptain = false;
    }


    /**
     * This method displays the profile of a pirate.
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
        System.out.println("Bounty: " + this.bounty);
        System.out.println("Role: " + this.role);
        if (this.pirateCrew == null){
            System.out.println("Crew: null");
        }
        else{
            System.out.println("Crew: " + this.pirateCrew.getName());
        }
        System.out.println("-----------------------------");
    }

    /**
     * This method returns the bounty of the pirate object.
     *         Parameters : None
     *         Returns :
     *         this.bounty - the pirate object's bounty
     * @return the pirate object's bounty
     */
    public double getBounty(){
        return this.bounty;
    }

    /**
     * This method returns the role of the pirate object.
     *         Parameters : None
     *         Returns :
     *         this.role - the pirate object's role
     * @return the pirate object's role
     */
    public String getRole(){
        return this.role;
    }

    /**
     * This method returns the pirate crew of the pirate object.
     *         Parameters : None
     *         Returns :
     *         this.pirateCrew - the pirate object's pirate crew
     * @return the pirate object's pirate crew
     */
    public PirateCrew getPirateCrew(){ return this.pirateCrew;}

    /**
     * This method returns the captain status of the pirate object.
     *         Parameters : None
     *         Returns :
     *         this.isCaptain - the pirate object's captain status
     * @return the pirate object's captain status
     */
    public boolean isCaptain(){
        return this.isCaptain;
    }

    /**
     *  This method makes the pirate captain of the crew they are in.
     *         Parameters : None
     *         Returns : None
     */
    public void makeCaptain(){
        this.role = "Captain";
        this.isCaptain = true;
        System.out.println(this.getName() + " is now the new Captain!");
    }

    /**
     * This method revokes the pirate of the captain role.
     *         Parameters : None
     *         Returns : None
     */
    public void revokeCaptain(){
        this.role = "Crew Member";
        this.isCaptain = false;
    }

    /**
     * This method sets the pirate's role.
     *         Returns : None
     * @param pRole the inputted role of the pirate
     * @param myObj the scanner object initiated in the main class
     */
    public void setRole(String pRole, Scanner myObj){
        int nInput, nMember;
        String buffer;

        if (this.role == null){
            this.role = pRole;
        }

        else if (this.role.equalsIgnoreCase(pRole)){
            System.out.println(this.getName() + " is already a " +
                    this.role + "!");
        }

        else if (this.pirateCrew.affiliationRoster.size() == 1){
            System.out.println("The crew cannot change captains, since it only" +
                    " has 1 member left!");
        }

        else if (this.role.equalsIgnoreCase("Captain")){
            System.out.println("This member is a captain. Change?");
            System.out.println("1 - Yes");
            System.out.println("Any other integer - No");
            nInput = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nInput == 1){
                System.out.println("Select a new captain");
                this.pirateCrew.displayMembers();
                System.out.print("Enter your choice's index: ");
                nMember = myObj.nextInt();
                buffer = myObj.nextLine();

                if (nMember >= 1 && nMember <= pirateCrew.affiliationRoster.size()){
                    this.pirateCrew.
                            changeCaptain(pirateCrew.affiliationRoster.get(nMember-1));
                }

                else{
                    System.out.println("Please enter a valid index!");
                }
            }

        }

        else if (pRole.equalsIgnoreCase("Captain")){
            this.pirateCrew.changeCaptain(this);
        }

        else{
            this.role = pRole;
        }
    }
}
