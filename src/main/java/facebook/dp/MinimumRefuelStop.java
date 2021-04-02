package facebook.dp;

public class MinimumRefuelStop {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target)
            return 0;
        int n = stations.length;
        int[] dp = new int[n+1] ;

        dp[0] = startFuel ;
        for(int i=0;i<n;i++){
            for(int t=i;t>=0;t--){
                if(dp[t]>=stations[i][0])
                    dp[t+1] = Math.max(dp[t+1],dp[t]+stations[i][1]) ;
            }
        }
        int ans = -1 ;
        for(int i=0;i<n;i++){
            if(dp[i]>=target)
                return i ;
        }
        return ans ;
    }
}
