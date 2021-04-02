package facebook;

public class UniqueBST {
    int[] dp = new int[20] ;

    public int numTrees(int n) {
        if(n==0 || n==1)
            return 1 ;
        if(dp[n]!=0)
            return dp[n] ;
        int ans = 0 ;
        for(int i=1;i<=n;i++){
            int left = numTrees(i-1) ;
            int right = numTrees(n-i) ;
            ans+=left*right ;
        }
        dp[n] = ans ;
        return ans ;
    }

    public static void main(String[] args) {
        UniqueBST uniqueBST = new UniqueBST() ;
        System.out.println(uniqueBST.numTrees(19) );
    }
}
