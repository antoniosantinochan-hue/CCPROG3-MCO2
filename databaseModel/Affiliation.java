package databaseModel;
import java.util.*;

/**
 * This is the Affiliation class. It is an abstract class.
 */
public abstract class Affiliation {
    // this is an array list used by all children classes of the affiliation class.
    public ArrayList<Character> affiliationRoster = new ArrayList<>();


    public abstract void groupOperations(int operation, Character c, Scanner myObj);
    public abstract String getName();
    public abstract void displayMembers();
    public abstract void displayAttributes();
}
