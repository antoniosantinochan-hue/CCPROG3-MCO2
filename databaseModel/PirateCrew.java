package databaseModel;
import java.util.*;

/**
 * This is the PirateCrew class. It inherits from the Affiliation class.
 */
public class PirateCrew extends Affiliation{

    private final int CREW_ID;
    private String crewName;
    private String shipName;
    private Character captain;
    private boolean hasCaptain;
    private double totalBounty;

    /**
     * This method is the PirateCrew class constructor.
     *         Returns : None
     * @param pCrewName name of the crew
     * @param pShip name of the ship
     * @param pID ID of the crew
     */
    public PirateCrew(String pCrewName, String pShip, int pID){
        this.CREW_ID = pID;
        this.crewName = pCrewName;
        this.shipName = pShip;
        this.totalBounty = 0;
        this.hasCaptain = false;
    }


    /**
     * This method serves as a menu for the crew's group operations.
     *         Returns : None
     * @param operation index of the chosen operation
     *         (1 for adding members, 2 for removing)
     * @param c pirate to be modified
     * @param myObj scanner object from main
     */
    public void groupOperations(int operation, Character c, Scanner myObj){
        int nInput, nMember;
        boolean isRunning;
        String role;
        String buffer;

        if (operation == 1){
            if (c instanceof Pirate && (((Pirate) c).getPirateCrew() == null)){
                affiliationRoster.add(c);
                ((Pirate) c).assignToCrew(this);

                if (affiliationRoster.size() == 1){
                    ((Pirate) c).makeCaptain();
                    this.captain = c;
                    this.hasCaptain = true;
                }

                else{
                    isRunning = true;
                    while (isRunning){
                        System.out.print("Enter your pirate's role: ");
                        role = myObj.nextLine();

                        if (role.equalsIgnoreCase("Captain")){
                            System.out.println("The crew already has a captain. Change?");
                            System.out.println("1 - Yes");
                            System.out.println("Any other integer - No");

                            nInput = myObj.nextInt();
                            buffer = myObj.nextLine();

                            if (nInput == 1){
                                changeCaptain(c);
                                isRunning = false;
                            }
                        }

                        else{
                            ((Pirate) c).setRole(role, myObj);
                            isRunning = false;
                        }
                    }
                }

                System.out.println(c.getName() + " has successfully joined "
                + this.getName() + " as a " + ((Pirate) c).getRole() + "!");
            }

            else if (c instanceof Pirate && (((Pirate) c).getPirateCrew() != null)){
                System.out.println("This character is already in a pirate crew!");
            }

            else{
                System.out.println("This character is not a pirate!");
            }
        }

        else if (operation == 2){
            System.out.println(c.getName() + " has been removed from the "
            + " crew as a " + ((Pirate) c).getRole());
            if (((Pirate) c).isCaptain()){
                this.hasCaptain = false;
                this.captain = null;
            }
            affiliationRoster.remove(c);
            ((Pirate) c).removeFromCrew();
        }

        if (!this.hasCaptain && (affiliationRoster.size() == 1)){
            ((Pirate) affiliationRoster.getFirst()).makeCaptain();
            this.captain = (Pirate) affiliationRoster.getFirst();
            this.hasCaptain = true;
        }

        else if (!this.hasCaptain && (affiliationRoster.size() > 1)){
            System.out.print("Select a new captain");
            this.displayMembers();
            System.out.print("Enter your choice: ");
            nMember = myObj.nextInt();
            buffer = myObj.nextLine();

            if (nMember >= 1 && nMember <= affiliationRoster.size()){
                ((Pirate) affiliationRoster.get(nMember-1)).makeCaptain();
                this.captain = (Pirate) affiliationRoster.get(nMember-1);
                this.hasCaptain = true;
            }

            else{
                System.out.println("Please enter a valid index!");
            }
        }

        countBounty();
    }

    /**
     * This method counts the total bounty of the crew after every group operation.
     *         Parameters : None
     *         Returns : None
     */
    public void countBounty(){
        this.totalBounty = 0;
        for (Character c : affiliationRoster){
            if (c.getStatus().equalsIgnoreCase("Free")){
                this.totalBounty = this.totalBounty + ((Pirate) c).getBounty();
            }
        }
    }

    /**
     * This method changes the captain of the crew.
     *         Returns : None
     * @param c inputted pirate to become captain
     */
    public void changeCaptain(Character c){
        ((Pirate) this.captain).revokeCaptain();

        ((Pirate) c).makeCaptain();
        this.captain = c;
    }

    /**
     * This method displays the members of the crew.
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
            System.out.println("This crew has no members.");
        }
    }

    /**
     * This method displays the attributes of the crew.
     *        Parameters : None
     *        Returns : None
     */
    public void displayAttributes(){
        System.out.println("-----------------------------");
        System.out.printf("Crew ID: %07d\n", this.CREW_ID);
        System.out.println("Crew Name: " + this.crewName);
        System.out.println("Ship Name: " + this.shipName);
        if (this.captain == null){
            System.out.println("Captain: null");
        }
        else{
            System.out.println("Captain: " + this.captain.getName());
        }
        System.out.println("Crew Members: ");
        displayMembers();
        System.out.println("Bounty: " + this.totalBounty);
        System.out.println("-----------------------------");
    }

    /**
     * This method returns the name of the pirate crew object.
     *        Parameters : None
     *        Returns :
     *        this.crewName - crew name of the pirate crew object
     * @return crew name of the pirate crew object
     */
    public String getName(){
        return this.crewName;
    }

    /**
     * This method sets the crew name of the pirate crew object.
     *        Returns : None
     * @param name inputted crew name of the pirate crew object
     */
    public void setCrewName(String name){
        this.crewName = name;
    }

    /**
     * This method sets the ship name of the pirate crew object.
     *        Returns : None
     * @param name inputted ship name of the pirate crew object
     */
    public void setShipName(String name){
        this.shipName = name;
    }
}
