package interviewbit.dp;

public class NDigitSum {
    public static final Integer MOD = 1000000007 ;
    public int getCount(int n,int sum){
        int[][] dp = new int[2][sum+1] ;

        int current = 0 ;
        int prev =1 ;
        for(int i=1;i<=sum;i++){
            dp[current][sum] = 0 ;dp[prev][sum] = 0 ;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(i==1){
                    if(j<=9)
                        dp[current][j] = 1 ;
                    else
                        dp[current][j] = 0 ;
                }else{
                    for(int k=0;k<=9;k++){
                        if(j>k)
                            dp[current][j] = (dp[current][j]+dp[prev][j-k])%MOD ;
                    }
                }
            }
            int temp =current ;
            current =prev ;
            prev=temp ;
        }

        return dp[prev][sum] ;


    }


    public static void main(String[] args) {
        NDigitSum digitSum = new NDigitSum() ;
        System.out.println(digitSum.getCount(3,6)) ;
    }

}
