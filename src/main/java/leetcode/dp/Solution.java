package leetcode.dp;

class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = k; // diff = 0
        dp[0][1] = 0; // same = 1
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][0]) * (k - 1);
            dp[i][1] = dp[i - 1][0];
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }


    public static void main(String[] args) {
        int n=4 ;
        int k= 2 ;
        Solution paintFence = new Solution() ;

        System.out.println(paintFence.numWays(4,2)) ;
    }
}
