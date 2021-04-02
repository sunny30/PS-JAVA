package facebook;

import java.util.Arrays;

public class CuttingSticks {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] ac = new int[cuts.length+2] ;
        ac[0] = 0 ;ac[ac.length-1] = n ;
        for(int i=0;i<cuts.length;i++){
            ac[i+1] = cuts[i] ;
        }
        int[][] dp = new int[ac.length][ac.length] ;

        for(int i=0;i<ac.length;i++){
            if(i+1<ac.length)
                dp[i][i+1] = 0 ;
            dp[i][i] = 0 ;
        }

        for(int len=3;len<=ac.length;len++){
            for(int i=0;i+len<=ac.length;i++){
                dp[i][i+len-1] = 10000000 ;
                for(int cut=i+1;cut<i+len-1;cut++){

                    int diff = ac[i+len-1]-ac[i] ;
                    dp[i][i+len-1] = Math.min(dp[i][cut]+dp[cut][i+len-1]+diff,dp[i][i+len-1]) ;


                }
            }
        }

        return dp[0][ac.length-1] ;
    }

    public static void main(String[] args) {
        CuttingSticks cuttingSticks = new CuttingSticks() ;
        int n = 7; int [] cuts = {1,3,4,5} ;
        int n1 = 9; int[] cuts1 = {5,6,1,4,2};
        System.out.println(cuttingSticks.minCost(n1,cuts1));
    }
}
