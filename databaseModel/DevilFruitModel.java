package databaseModel;
import java.util.*;

public class DevilFruitModel {
    public static ArrayList<DevilFruit> devilFruitRegistry =
            new ArrayList<>();

    public void addDevilFruit(DevilFruit d){
        devilFruitRegistry.add(d);
    }

    public ArrayList<DevilFruit> getDevilFruitRegistry(){
        return devilFruitRegistry;
    }
}
