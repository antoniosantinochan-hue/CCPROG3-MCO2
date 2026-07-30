package databaseModel;
import java.util.*;

public class CharacterRegistryModel {
    public static ArrayList<Character> characterRegistry = new ArrayList<>();
    private int characterCount = 0;

    public void addCharacter(Character c){
        characterRegistry.add(c);
        characterCount++;
    }

    public void removeCharacter(int index){
        characterRegistry.remove(index);
    }

    public ArrayList<Character> getCharacterRegistry(){
        return characterRegistry;
    }

    public int getCharacterCount(){
        return this.characterCount;
    }
}
