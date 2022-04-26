import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public void PolybiusEncryption_2() {
        // The Final List where we stored the key message and the normal alphabet.
        ArrayList<ArrayList<Character>> alphabetWithKeyMessage = new ArrayList<>();
        // Here we permanently put the Characters of the key message.
        ArrayList<Character>  userMessageCharacterList = new ArrayList<>();
        // Here we put the Key Message and the normal alphabet together to remove duplicates.
        Set<Character> temp2 = new LinkedHashSet<Character>();
        // Just the Blueprint of a normal alphabet.
        ArrayList<Character> normalAlphabet = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

        String userMessageKey = "Marvel";
        System.out.println("User Inputted Key : " + userMessageKey);

        // Adding the key Message to Array List.
        int counter = 0;
        for(int i = 0; i < getKey().length(); i++) {
            userMessageCharacterList.add(i, getKey().toUpperCase().charAt(counter));
            counter = counter + 1;
        }
        System.out.println("User Message Character : " + userMessageCharacterList);

        // adding the User Message and the Normal Alphabet letters.
        for(int i = 0; i < userMessageCharacterList.size(); i++) {
            temp2.add(userMessageCharacterList.get(i));
        }
        for(int i = 0; i < normalAlphabet.size(); i++) {
            temp2.add(normalAlphabet.get(i));
        }

        // convert the LinkedHashSet to ArrayList.
        ArrayList<Character> list = new ArrayList<>(temp2);

        int messageCounter = 0;
        for(int rows = 0; rows < 5; rows++) {
            alphabetWithKeyMessage.add(rows, new ArrayList<Character>());
            for (int cols = 0; cols < 5; cols++) {
                alphabetWithKeyMessage.get(rows).add(cols, list.get(messageCounter));
                messageCounter = messageCounter + 1;
            }
        }
        // Printing 2D ArrayList.
        for (ArrayList<Character> temp: alphabetWithKeyMessage) {
            System.out.println(temp);
        }
    }
}
