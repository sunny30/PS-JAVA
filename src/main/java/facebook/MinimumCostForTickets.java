package facebook;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {

        int len = days.length ;
        int[][] dp = new int[len][3] ;
        dp[0][0] = costs[0] ;dp[0][1] = costs[1] ;dp[0][2] = costs[2] ;
        for(int i=1;i<len;i++){

            dp[i][0] = Math.min(dp[i-1][0],Math.min(dp[i-1][1],dp[i-1][2])) + costs[0] ;

            int j= i-1 ;
            while(j>=0 && days[i]-days[j]+1<=7)
                j-- ;
            if(j>=0)
                dp[i][1] = Math.min(dp[j][0],Math.min(dp[j][1],dp[j][2])) + costs[1] ;
            else
                dp[i][1] = costs[1] ;

            while(j>=0 && days[i]-days[j]+1<=30)
                j-- ;

            if(j>=0)
                dp[i][2] = Math.min(dp[j][0],Math.min(dp[j][1],dp[j][2])) + costs[2] ;
            else
                dp[i][2] = costs[2] ;
        }

        return Math.min(dp[len-1][0],Math.min(dp[len-1][1],dp[len-1][2])) ;
    }

    public static void main(String[] args) {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31} ;
        int[] costs = {2,7,15} ;
        MinimumCostForTickets minimumCostForTickets = new MinimumCostForTickets();
        System.out.println(minimumCostForTickets.mincostTickets(days,costs)) ;
    }
}
