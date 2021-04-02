package facebook;

public class CheapestFlightInKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int[][] adj = new int[n][n] ;
        int[][] dp = new int[K+1][n] ;
        for(int i=0;i<n;i++){
            for(int j = 0 ;j<n;j++)
                adj[i][j] = -1 ;
        }

        for(int k=0;k<=K;k++){
            for(int i=0;i<n;i++){
                dp[k][i] = Integer.MAX_VALUE ;
            }
        }

        for(int i =0;i<flights.length;i++){
            int s = flights[i][0] ;
            int d = flights[i][1] ;
            int c = flights[i][2] ;
            if(adj[s][d]==-1)
                adj[s][d] = c ;
            else
                adj[s][d] = Math.min(c,adj[s][d]) ;
        }

        for(int i = 0;i<n;i++){
            if(adj[src][i]!=-1)
                dp[0][i] = adj[src][i] ;
            else
                dp[0][i] = Integer.MAX_VALUE ;
        }

        for(int k=1;k<=K;k++){
            for(int s=0;s<n;s++){
                for(int d=0;d<n;d++){
                    if(dp[k-1][s]!=Integer.MAX_VALUE && s!=dst && adj[s][d]!=-1){
                        dp[k][d] = Math.min(dp[k][d],dp[k-1][s]+adj[s][d]) ;
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE ;

        for(int k=0;k<=K;k++){
            ans = Math.min(ans,dp[k][dst]) ;
        }
        if(ans==Integer.MAX_VALUE)
            return -1 ;
        return ans ;
    }


}
