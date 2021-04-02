package facebook;

public class PerfectSquares {
    public int numSquares(int n) {
        int[][] dp = new int[100][n+1] ;

        for(int i=1;i<=n;i++)
            dp[1][i] = i ;
        int i =2 ;
        for(i=2;i*i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i*i>j)
                    dp[i][j] = dp[i-1][j] ;
                else if(i*i==j)
                    dp[i][j] = 1 ;
                else{
                    dp[i][j] = Math.min(dp[i][j-i*i]+1,dp[i-1][j]) ;
                }
            }
        }
        return dp[i][n] ;
    }
}
