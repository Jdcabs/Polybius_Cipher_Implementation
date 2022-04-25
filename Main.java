import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        create2DArrayList();
    }
    static void create2DArrayList(){
        ArrayList<ArrayList<Character>> Alphabet = new ArrayList<>();
        // Here we're Instantiating the Row0 of the ArrayList,
        Alphabet.add(new ArrayList<Character>(Arrays.asList('A','B','C','D','E')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('F','G','H','I','J')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('K','L','M','N','O')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('P','Q','R','S','T')));
        Alphabet.add(new ArrayList<Character>(Arrays.asList('U','V','W','X','Y')));

        String userMessage = "david";

        /*Alphabet.get(0).remove(0);
        Alphabet.get(0).add(0,'d');*/

        // int col = 0;
        /*int alphabetSize = Alphabet.size();
        for (int row = 0; row < alphabetSize; row++) {
            for(int cols = 0; cols < alphabetSize; cols++){
                System.out.println(Alphabet.get(row).get(cols));
            }
        }*/

        for (ArrayList<Character> alph : Alphabet) {
            System.out.println(alph);
        }
    }
}
