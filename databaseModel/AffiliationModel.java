package databaseModel;
import java.util.*;

public class AffiliationModel {
    public static ArrayList<Affiliation> affiliationRegistry =
            new ArrayList<Affiliation>();

    public void addAffiliation(Affiliation a){
        affiliationRegistry.add(a);
    }

    public ArrayList<Affiliation> getAffiliationRegistry(){
        return affiliationRegistry;
    }
}
