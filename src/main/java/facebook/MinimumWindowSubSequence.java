package facebook;

public class MinimumWindowSubSequence {

    public int[] getDiff(int[][] dp, int i, int j) {
        int[] diff = new int[26];
        for (int k = 0; k < 26; k++) {
            if (i > 0)
                diff[k] = dp[j][k] - dp[i - 1][k];
            else
                diff[k] = dp[j][k];
        }

        return diff;


    }

    boolean satisfiability(int[] src, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (src[i] < target[i])
                return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int st = -1;
        int ed = -1;
        int ans = s.length() + 1;
        s = s.toUpperCase() ;
        t = t.toUpperCase() ;
        int[][] dp = new int[s.length()][26];
        int[] target = new int[26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            dp[i][s.charAt(i) - 'A']++;

        }
        for (int i = 0; i < 26; i++) {
            target[i] = 0;
        }
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i) - 'A']++;
        }
        int i = 0;
        int j = t.length() - 1;


        while (i <= j && j < s.length()) {
            int[] diff = getDiff(dp, i, j);
            while (i<=j && satisfiability(diff, target)) {
                if (j - i + 1 < ans) {
                    ans = j - i + 1;
                    st = i;
                    ed = j;
                }
                i++;
                diff = getDiff(dp, i, j);

            }

            j++;


        }
        if (ans <= s.length())
            return s.substring(st, ed + 1);
        else
            return "";
    }


    public static void main(String[] args) {
        MinimumWindowSubSequence minimumWindowSubSequence = new MinimumWindowSubSequence();
        String s = "ADOBECODEBANC".toUpperCase();
        String t = "ABC".toUpperCase();

        String s1 = "A";String t1="A";
        System.out.println(minimumWindowSubSequence.minWindow(s1, t1));
    }

}
