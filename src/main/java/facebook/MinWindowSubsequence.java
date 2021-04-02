package facebook;

public class MinWindowSubsequence {

    public String minWindow(String S, String T) {
        int[][] dp = new int[T.length()][S.length()] ;
        int[][] parent = new int[T.length()][S.length()] ;


        for(int i=0;i<T.length();i++){
            for(int j=0;j<S.length();j++){
                if(i==0){
                    if(T.charAt(i)==S.charAt(j)){
                        dp[i][j] = 1 ;
                        parent[i][j] = j ;
                    }else{
                        dp[i][j] = (j>0)?dp[i][j-1]:0 ;
                        parent[i][j] = (j>0)?parent[i][j-1]:-1 ;
                    }
                }else{
                    if(T.charAt(i)==S.charAt(j)){
                        if(i>0 && j>0) {
                            dp[i][j] = 1 + dp[i - 1][j - 1];
                            if(dp[i][j]==i+1)
                                parent[i][j] = parent[i-1][j-1];
                            else{
                                dp[i][j] = 0 ;
                                parent[i][j] = -1 ;
                            }
                        }else{
                            dp[i][j] = 0 ;
                            parent[i][j] = -1 ;
                        }

                    }else{

                        dp[i][j] = ((j>0)?dp[i][j-1]:0) ;
                        parent[i][j] = ((j>0)?parent[i][j-1]:-1) ;
                    }
                }
            }
        }
        int st =-1 ;
        int ans = S.length()+1;

        for(int i=0;i<S.length();i++){
            if(dp[T.length()-1][i]==T.length()){
                if(i-parent[T.length()-1][i]+1 < ans){
                    ans = i-parent[T.length()-1][i]+1 ;
                    st = parent[T.length()-1][i] ;
                }
            }
        }
        if(ans==S.length()+1)
            return "" ;
        else{
            return S.substring(st,st+ans) ;
        }
    }

    public static void main(String[] args) {
        MinWindowSubsequence minWindowSubsequence = new MinWindowSubsequence();
        System.out.println(minWindowSubsequence.minWindow("abcdebdde","zdbdde"));
    }

}
