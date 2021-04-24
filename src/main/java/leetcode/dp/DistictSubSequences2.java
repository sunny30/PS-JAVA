package leetcode.dp;

public class DistictSubSequences2 {
    public static Integer MOD = 1000000007 ;
    public int distinctSubseqII(String S) {
        int[] charCount = new int[26] ;
        int[] dp = new int[2] ;
        int curr =0 ;
        int prev = 1 ;
        charCount[S.charAt(0)-'a'] = 1 ;
        for(int i=1;i<S.length();i++){
            curr  = ((2*prev)%MOD+1)%MOD ;
            curr = ((curr-charCount[S.charAt(i)-'a'])%MOD+MOD)%MOD ;

            charCount[S.charAt(i)-'a'] += (prev+1-charCount[S.charAt(i)-'a'])%MOD ;

            prev = curr ;
        }
        return prev ;
    }

    public static void main(String[] args) {
        String s = "abc" ;
        String s1 = "aba" ;
        String s2 = "aaa" ;
        String s3 = "lee" ;
        String s4 = "cfffe" ;
        DistictSubSequences2 subSequences2 = new DistictSubSequences2() ;
        System.out.println(subSequences2.distinctSubseqII(s4));
    }
}
