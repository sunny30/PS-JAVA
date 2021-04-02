package leetcodeuber;

import java.util.ArrayList;
import java.util.List;

public class KLongestSubstringWithKCharacters {

    public boolean isValidSubString(int[][] table, int st, int lt, int k) {
        if (lt < st)
            return false;
        if (st == 0) {
            for (int i = 0; i < 26; i++) {

                if (table[lt][i] != 0 && table[lt][i] < k)
                    return false;
            }
            return true;
        } else {
            for (int i = 0; i < 26; i++) {
                if (table[lt][i] != table[st - 1][i] && (table[lt][i] - table[st - 1][i] < k))
                    return false;
            }
            return true;
        }
    }

    public int windowSearch(int[][] frequencyTable, int st, int lt, int k, String s) {
        int ans = 0;
        for (int i = st; i <= lt; i++) {
            if (frequencyTable[lt][s.charAt(i) - 'a'] < k) {
                if (isValidSubString(frequencyTable, st, i - 1, k)) {
                    ans = Math.max(ans, i - st);
                }
                st = i + 1;
            } else if (isValidSubString(frequencyTable, st, i, k)) {
                ans = Math.max(ans, i - st + 1);
            }
        }
        return ans;

    }

    public int longestSubstring(String s, int k) {
        int len = s.length();
        int[][] frequencyTable = new int[len][26];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 26; j++)
                frequencyTable[i][j] = 0;
        }

        frequencyTable[0][s.charAt(0) - 'a']++;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 26; j++)
                frequencyTable[i][j] = frequencyTable[i - 1][j];
            frequencyTable[i][s.charAt(i) - 'a']++;
        }

        int st = 0;
        int lt = 0;
        int ans = 0;


        List<Integer> divideIndex = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (frequencyTable[len - 1][s.charAt(i) - 'a'] < k) {
                divideIndex.add(i);
            }
        }

        if(divideIndex.size()==0)
            return len ;

        for (int i = 0; i < divideIndex.size(); i++) {

            if (i == 0)
                ans = Math.max(ans, windowSearch(frequencyTable, 0, divideIndex.get(i) - 1, k, s));
            if (i == 0)
                ans = Math.max(ans, windowSearch(frequencyTable, 0, divideIndex.get(i) - 1, k, s));
            else if(i==divideIndex.size()-1) {
                ans = Math.max(ans, windowSearch(frequencyTable, divideIndex.get(i) + 1, len - 1, k, s));
                ans = Math.max(ans, windowSearch(frequencyTable, divideIndex.get(i - 1) + 1, divideIndex.get(i) - 1, k, s));
            }else{
                ans = Math.max(ans, windowSearch(frequencyTable, divideIndex.get(i - 1) + 1, divideIndex.get(i) - 1, k, s));
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        KLongestSubstringWithKCharacters substringWithKCharacters = new KLongestSubstringWithKCharacters();
        System.out.println(substringWithKCharacters.longestSubstring("bchhbbdefghiaaacb", 3));
    }

}
