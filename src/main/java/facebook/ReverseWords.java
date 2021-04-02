package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        List<String> wordsList = new ArrayList<String>();

        for (String word : words) {
            String refineWord = word.replaceAll(" ", "");
            if (refineWord.length() > 0)
                wordsList.add(refineWord);
        }
        Collections.reverse(wordsList);
        String ans = "";

        for (int i = 0; i < wordsList.size(); i++) {
            if (i == 0)
                ans += wordsList.get(0);
            else
                ans += (" " + wordsList.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {

        String input = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(input));
    }
}
