package toptal;

public class Second {

    public String solution(String S) {
        // write your code in Java SE 8
        if(S.length()<4)
            return S ;
        String tans = "" ;
        for (int i = 0; i < S.length(); i++) {
            //Character ch = new Character(S.charAt(i)) ;
                if(Character.isDigit(S.charAt(i))){
                    tans +=S.charAt(i) ;
                }
        }
        int n = tans.length() ;
        boolean breakTwo = false ;
        if(n%3==1){
            breakTwo =true ;
            n=n-4 ;
        }


        int cnt =1 ;
        String ans ="" ;
        while (cnt<=n){
            ans+=tans.charAt(cnt-1) ;
            if(cnt%3==0 && cnt!=n)
                ans = ans+"-" ;
            cnt++ ;
        }

        if(breakTwo){
            ans+="-" ;
            ans += tans.charAt(n) ;
            ans += tans.charAt(n+1) ;
            ans+="-" ;
            ans+= tans.charAt(n+2) ;
            ans+=tans.charAt(n+3) ;
        }
        return ans ;
    }

    public static void main(String[] args) {
        Second second = new Second() ;
        String s = "00-44  48 5555 8361";
        String s1 = "0 - 22 1985--324" ;
        String s2 = "555372654" ;
        String s3 = "123" ;
        String s4 = "1223" ;
        System.out.println(second.solution(s4)) ;
    }
}
