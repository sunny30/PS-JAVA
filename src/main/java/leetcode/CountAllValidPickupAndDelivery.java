package leetcode;

public class CountAllValidPickupAndDelivery {
    public static final  Integer mod = 1000000007 ;
    static int[][] dp = new int[501][501] ;
    int count(int n, int p, int d, int lim){
        if(d>p || p==0 || d<0 || p<0)
            return 0 ;
        if(n==1 && p==1)
            return lim ;
        if(dp[p][d]!=0){
            return dp[p][d] ;
        }
        dp[p][d] = (((p-d+1)* (count(n-1,p,d-1,lim)%mod))%mod + ((lim-p+1)* (count(n-1,p-1,d,lim)%mod))%mod )%mod;
        return dp[p][d] ;
    }

    public int countOrders(int n) {
        return count(2*n,n,n,n) ;
    }

    public static void main(String[] args) {
        int n=8 ;
        CountAllValidPickupAndDelivery delivery = new CountAllValidPickupAndDelivery() ;
        System.out.println(delivery.countOrders(n)) ;
    }
}
