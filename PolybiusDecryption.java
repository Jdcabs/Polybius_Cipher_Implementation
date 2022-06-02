import java.util.*;

public class PolybiusDecryption {

    private String key;
    private Long encryptedMessage;

    PolybiusDecryption(){}

    public void setKey(String key) {this.key = key;}
    public void setEncryptedMessage(Long encryptedMessage) {this.encryptedMessage = encryptedMessage;
    }
    public String getKey() {
        return key;
    }

    public Long getEncryptedMessage() {
        return encryptedMessage;
    }

    public void DecryptionImpl(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPlease Enter the Encrypted Message: ");
        String encryptedMessage = scanner.nextLine();
        Long decryption = Long.parseLong(encryptedMessage);

        System.out.print("Enter a Secret Key: ");
        String key = scanner.nextLine();

        setEncryptedMessage(decryption);
        setKey(key);
    }

    public String  Decryption() {
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

        // Printing 2D ArrayList(table).
        for (ArrayList<Character> temp: alphabetWithKeyMessage) {
            System.out.println(temp);
        }

        // Converting getEncryptedMessage to int Array.
            String temp = Long.toString(getEncryptedMessage());
            int[] numbers = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++) {
                numbers[i] = temp.charAt(i) - '0';
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        // To Access the letters in the 2D Array list we have to subtract 1.
        for (Integer temps :
                numbers) {
            arrayList.add(temps - 1);
        }

        String result = "";
        int first = 0;
        int second = 1;
        for(int i = 0; i < arrayList.size(); i = i + 2) {
            result = result + alphabetWithKeyMessage.get(arrayList.get(first)).get(arrayList.get(second));
            first = first + 2;
            second = second + 2;
        }
        return result;
    }
}
