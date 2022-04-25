import java.util.ArrayList;
import java.util.Arrays;

public class PolybiusEncryption {

    private final String message;
    private final String key;

    PolybiusEncryption(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getKey() {
        return key;
    }

    public void PolybiusEnryption() {
        // Here we create a Multidimensional Arraylist.
        ArrayList<ArrayList<Character>> Alphabet = new ArrayList<>();
        // Here we're Instantiating the Row0 to Row5 of the ArrayList, at the same time we add the Alphabetical table.
        Alphabet.add(new ArrayList<Character>(Arrays.asList('A','B','C','D','E')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('F','G','H','I','J')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('K','L','M','N','O')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('P','Q','R','S','T')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('U','V','W','X','Y')));

    }
}
