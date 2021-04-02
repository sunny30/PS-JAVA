package facebook;

public class MinDaysOrange {

    int[] dp = new int[1000001] ;

    int findRecursive(int n) {
        if(n<=1000000)
            return dp[n] ;
        int n1 = Integer.MAX_VALUE-10 ;
        int n2 = Integer.MAX_VALUE-10 ;
        if(n%3==0)
             return  (findRecursive(n/3)+1) ;
        if(n%2==0)
            return findRecursive(n/2)+1 ;
        return findRecursive(n-1)+1 ;



    }
    public int minDays(int n) {
          dp[1] = 1 ;
          dp[3] = 2 ;dp[2] = 2 ;

          for(int i=4;i<=1000000;i++){
              int temp = Integer.MAX_VALUE-10 ;
              int temp1 = Integer.MAX_VALUE-10 ;

              if(i%2==0)
                  temp = dp[i/2]+1 ;
              if(i%3==0)
                  temp1 =dp[i/3]+1 ;


              dp[i] = Math.min(dp[i-1]+1,Math.min(temp,temp1)) ;
          }

          if(n<=1000000)
              return dp[n] ;
          else
              return findRecursive(n) ;
    }
}
