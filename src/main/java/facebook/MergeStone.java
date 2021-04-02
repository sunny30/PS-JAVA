package facebook;

public class MergeStone {


    public int mergeStones(int[] stones, int K) {
        int n = stones.length;

        if ((n - K) % (K - 1) != 0)
            return -1;
        else {
            for (int i = 1; i < stones.length; i++)
                stones[i] += stones[i - 1];

            int[][] dp = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    dp[i][j] = 1000000 ;
            }

            dp[0][K - 1] = stones[K - 1];

            for (int i = K; i < n; i++) {
                dp[i - K + 1][i] = stones[i] - stones[i - K];
            }

           for(int len = 2*K-1;len<=n;len+=(K-1)) {
                for (int i = 0; i + len <= n; i++) {
                    dp[i][i+len-1] = 1000000 ;
                    for(int j =i;j<i+len;j++ ){
                        int sum = ((i>0)?(stones[i+len-1]-stones[i-1]):stones[i+len-1]) ;
                        if(j+len-K<n)
                        dp[i][i+len-1] = Math.min((dp[j][j+len-K]+sum),dp[i][i+len-1]) ;
                    }
                }
            }
            return dp[0][n-1] ;
        }
    }


    public static void main(String[] args) {
        MergeStone mergeStone = new MergeStone() ;
        int[] input = {3,5,1,2,6} ;
        int[] input1 = {3,2,4,1} ;

        System.out.println(mergeStone.mergeStones(input,3)) ;
        System.out.println(mergeStone.mergeStones(input1,2));
    }
}
