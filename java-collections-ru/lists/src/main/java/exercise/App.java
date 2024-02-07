package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public  class App {

    public static boolean scrabble(String letters, String word) {
        if (letters == null || word == null) {
            return false;
        }
        letters = letters.replaceAll("\\s+", "").toLowerCase();
        word = word.replaceAll("\\s+", "").toLowerCase();
        for (char c : word.toCharArray()) {
            int index = letters.indexOf(c);
            if (index == -1) {
                return false;
            }
            letters = letters.substring(0, index) + letters.substring(index + 1);
        }

        return true;
    }
}
//END
