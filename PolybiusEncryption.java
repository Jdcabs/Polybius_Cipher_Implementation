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

    public String Encryption() {
        // The Final List where we stored the key message and the normal alphabet.
        ArrayList<ArrayList<Character>> alphabetWithKeyMessage = new ArrayList<>();
        // Here we permanently put the Characters of the key message.
        ArrayList<Character>  userMessageCharacterList = new ArrayList<>();
        // Here we put the Key Message and the normal alphabet together to remove duplicates.
        Set<Character> temp2 = new LinkedHashSet<>();
        // Just the Blueprint of a normal alphabet.
        ArrayList<Character> normalAlphabet = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

        // Adding the key Message to Array List.
        int counter = 0;
        for(int i = 0; i < getKey().length(); i++) {
            userMessageCharacterList.add(i, getKey().toUpperCase().charAt(counter));
            counter = counter + 1;
        }

        // adding the User Message and the Normal Alphabet letters.
        temp2.addAll(userMessageCharacterList);
        temp2.addAll(normalAlphabet);

        // convert the LinkedHashSet to ArrayList.
        ArrayList<Character> list = new ArrayList<>(temp2);

        int listCounter = 0;
        for(int rows = 0; rows < 5; rows++) {
            alphabetWithKeyMessage.add(rows, new ArrayList<>());
            for (int cols = 0; cols < 5; cols++) {
                alphabetWithKeyMessage.get(rows).add(cols, list.get(listCounter));
                listCounter = listCounter + 1;
            }
        }

        // Printing 2D ArrayList.
        /*for (ArrayList<Character> temp: alphabetWithKeyMessage) {
            System.out.println(temp);
        }*/

        ArrayList<Integer> encryptedMessage = new ArrayList<>();
        for(int messageCounter = 0; messageCounter < getMessage().length(); messageCounter++) {
            for (int rows = 0; rows < 5; rows++) {
                for (int cols = 0; cols < 5; cols++) {
                    if (alphabetWithKeyMessage.get(rows).get(cols).equals(getMessage().toUpperCase().charAt(messageCounter)) && messageCounter < getMessage().length()) {
                        encryptedMessage.add(rows);
                        encryptedMessage.add(cols);
                    }
                }
            }
        }

        for(int i = 0; i < encryptedMessage.size(); i++){
            int temp = encryptedMessage.get(i);
            encryptedMessage.remove(i);
            temp = temp + 1;
            encryptedMessage.add(i, temp);
        }

        String result = "";
        for(int i = 0; i < encryptedMessage.size(); i++) {
            result = result + "" + Integer.parseInt(String.valueOf(encryptedMessage.get(i)));
        }
        return result;
    }
}
