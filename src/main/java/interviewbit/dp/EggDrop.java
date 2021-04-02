package interviewbit.dp;

public class EggDrop {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1] ;
        for(int k=1;k<=K;k++){
            for(int n=1;n<=N;n++){
                if(k==1){
                    dp[k][n] =n ;
                }else{
                    dp[k][n] = n ;
                    if(n<=k){
                        dp[k][n] = dp[k-1][n] ;
                    }else{
                        for(int i=2;i<n;i++){
                            dp[k][n] = Math.min(dp[k][n],Math.max(1+dp[k-1][i-1],1+dp[k][n-i])) ;
                        }
                    }
                }

            }
        }
        return dp[K][N] ;

    }

    public static void main(String[] args) {
        EggDrop eggDrop = new EggDrop() ;
        System.out.println(eggDrop.superEggDrop(3,14) );
    }
}
