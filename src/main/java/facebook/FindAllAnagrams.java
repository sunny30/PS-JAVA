package facebook;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public boolean checkcompare(int[] s, int[] t) {
        for (int i = 0; i < 26; i++) {
            if (s[i] != t[i])
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s2, String s1) {
        int len1 = s1.length();
        int len2 = s2.length();
        List<Integer> ans = new ArrayList<Integer>() ;
        if (len2 < len1)
            return ans;
        int[][] pref = new int[len2][26];
        int[] target = new int[26];
        for (int i = 0; i < 26; i++)
            target[i] = 0;
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < 26; j++) {
                if (i > 0) {
                    pref[i][j] = pref[i - 1][j];
                } else {
                    pref[i][j] = 0;
                }
            }
            pref[i][s2.charAt(i) - 'a']++;
            if (i < len1)
                target[s1.charAt(i) - 'a']++;
        }
        if (checkcompare(pref[len1 - 1], target))
            ans.add(0);

        for (int i = len1; i < len2; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < 26; j++) {
                temp[j] = pref[i][j] - pref[i - len1][j];

            }
            if (checkcompare(temp, target) == true)
                ans.add(i-len1+1);
        }
        return ans;

    }
}
