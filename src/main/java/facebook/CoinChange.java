package facebook;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0 ;
        int[][] dp = new int[2][amount + 1];
        Arrays.sort(coins);
        int current = 0 ;
        int prev =1 ;
        dp[current][0] = 0 ;
        dp[prev][0] = 1 ;
        for(int i=0;i<coins.length;i++){

            for(int j=1;j<=amount;j++){
                if(coins[i]<=amount){
                    if(i==0){
                        if(j==coins[i])
                            dp[current][j] = 1 ;
                        else
                            dp[current][j] = ((j>coins[i] && dp[current][j-coins[i]]!=0)?dp[current][j-coins[i]]+1:0) ;
                    }else{

                        if(coins[i]==j){
                            dp[current][j] = 1 ;
                        }else{
                            dp[current][j] = dp[prev][j] ;
                            if(j>coins[i] && dp[current][j-coins[i]]!=0) {
                                // dp[current][j] = 1;
                                if(dp[current][j]!=0)
                                    dp[current][j] = Math.min(dp[current][j], dp[current][j - coins[i]] + 1);
                                else{
                                    dp[current][j] = dp[current][j - coins[i]] + 1 ;
                                }
                            }
                        }
                    }
                }else{
                    dp[current][j] = dp[prev][j] ;
                }

            }
            int temp = prev ;
            prev =current ;
            current =temp ;
        }
        return ((dp[prev][amount]==0)?-1:dp[prev][amount]) ;
    }

    public static void main(String[] args) {
        int[] coins = {3,5} ;
        CoinChange coinChange = new CoinChange() ;
        System.out.println(coinChange.coinChange(coins,8)) ;
    }
}
