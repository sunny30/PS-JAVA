package facebook;

public class PalindromicSubStrings {

    public int countSubstrings(String s) {
        int len = s.length() ;
        boolean[][] dp =  new boolean[len][len] ;

        int count = len ;

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++)
                dp[i][j] =false ;
        }

        for(int i=0;i<len;i++){
            dp[i][i] = true ;
            if(i>0 && s.charAt(i)==s.charAt(i-1)) {
                dp[i - 1][i] = true;
                count++ ;
            }
        }

        for(int i=3;i<=len;i++){
            for(int j=0;i+j-1<len;j++){
                if(s.charAt(j)==s.charAt(i+j-1) && dp[j+1][i+j-2]==true){
                    dp[j][i+j-1] = true ;
                    count++ ;
                }
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        PalindromicSubStrings palindromicSubStrings = new PalindromicSubStrings() ;
        System.out.println(palindromicSubStrings.countSubstrings("aaa")) ;
    }
}
