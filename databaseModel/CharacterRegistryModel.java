package databaseModel;
import java.util.*;

public class CharacterRegistryModel {
    public static ArrayList<Character> characterRegistry;
    private int characterCount = 0;

    public CharacterRegistryModel(){
        ArrayList<Character> characterRegistry =
                new ArrayList<Character>();
    }

    public void addCharacter(Character c){
        characterRegistry.add(c);
        characterCount++;
    }

    public ArrayList<Character> getCharacterRegistry(){
        return characterRegistry;
    }

    public int getCharacterCount(){
        return this.characterCount;
    }
}
