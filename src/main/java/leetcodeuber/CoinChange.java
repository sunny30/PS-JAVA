package leetcodeuber;

public class CoinChange {

    public int change(int amount, int[] coins) {

        int[][] dp = new int[2][amount+1] ;

        int curr = 0 ;
        int prev = 1 ;
        dp[curr][0]=1 ;
        for(int i=coins[0];i<=amount;i+=coins[0]){
            dp[curr][i] = 1 ;
        }

        curr = 1 ;
        prev = 0 ;

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j<coins[i])
                    dp[curr][j] = dp[prev][j];
                else {
                    dp[curr][j] = dp[prev][j];
                    dp[curr][j] = dp[curr][j] + dp[curr][j - coins[i]];
                }
            }
            int temp = prev ;
            prev = curr ;
            curr = temp ;
        }

        return dp[prev][amount] ;
    }


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange() ;
        int coins[] = {1, 2, 5} ;
        int amount =  5;
        System.out.println(coinChange.change(amount,coins));
    }
}
