package facebook;

public class PermutationInString {

    public boolean checkcompare(int[] s, int[] t) {
        for (int i = 0; i < 26; i++) {
            if (s[i] != t[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 < len1)
            return false;
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
            return true;

        for (int i = len1; i < len2; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < 26; j++) {
                temp[j] = pref[i][j] - pref[i - len1][j];

            }
            if (checkcompare(temp, target) == true)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("ab", "eidboaoo"));
    }
}
