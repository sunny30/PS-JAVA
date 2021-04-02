package facebook;

public class LongestPalindromicSubSequence {

    public int longestPalindromeSubseq(String s) {
        if(s.length()<1)
            return 0 ;
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = 2;
            } else if (i > 0) {
                dp[i - 1][i] = 1;
            }

        }

        for(int l =3;l<=len;l++){
            for(int i=0;i+l-1<len;i++){
                dp[i][i+l-1] = Math.max(dp[i][i+l-2],dp[i+1][i+l-1]) ;
                if(s.charAt(i)==s.charAt(i+l-1)){
                    dp[i][i+l-1] = Math.max(dp[i+1][i+l-2]+2,dp[i][i+l-1]) ;
                }
            }
        }
        return dp[0][len-1] ;
    }

    public static void main(String[] args) {
        LongestPalindromicSubSequence palindromicSubSequence = new LongestPalindromicSubSequence() ;
        System.out.println(palindromicSubSequence.longestPalindromeSubseq("bbbab"));
    }
}
