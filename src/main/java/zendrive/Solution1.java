package zendrive;

import java.util.Collections;

public class Solution1 {

    public boolean validOperation(String s1,String s2,int charPos,boolean reverse){

        if(charPos==s1.length() && s1.charAt(charPos-1)==s2.charAt(charPos-1))
            return true ;

        if(charPos>s1.length()-1)
            return false;

        if(s1.charAt(charPos)=='A'){
            s2 = s2+'A' ;
            return validOperation(s1,s2,charPos+1,false) ;
        }else{
            int len2 = s2.length() ;
            String interim = "" ;
            for(int i=len2-1;i>=0;i--){
                if(s2.charAt(i)!=s1.charAt(len2-1-i))
                    return false ;
                else
                    interim+=s2.charAt(i) ;

            }
             return validOperation(s1,interim+'B',charPos+1,true) ;
        }

    }

    public static void main(String[] args) {
        /*
            if len1 = |s1|
            len2 =|s2|
            if(len2+1 =='B' && reverse(s2)==s1(0,len2))
         */

        Solution1 solution1 = new Solution1() ;
        String s1 = "BABBA" ;
        String s2 = "AB" ;
        boolean isreverse = true ;
        boolean isprefix = true ;
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)!=s1.charAt(i))
                isprefix = false ;
        }
        String reverse = "" ;
        for(int i=s2.length()-1;i>=0;i--) {
            if (s2.charAt(i) != s1.charAt(s2.length() - 1 - i))
                isprefix = false;
            else
                reverse += s2.charAt(i) ;
        }
        boolean ans = false ;
        if(isprefix&&isreverse){
             ans = solution1.validOperation(s1,s2,s2.length(),false) || solution1.validOperation(s1,reverse,s2.length(),true) ;
        }else{
            if(isprefix)
                ans = solution1.validOperation(s1,s2,s2.length(),false) ;
            else if(isreverse){
                ans  = solution1.validOperation(s1,s2,s2.length(),true) ;
            }

        }

        System.out.println(ans);



        //System.out.println(solution1.validOperation("ABABABA","ABA",3,false)) ;
    }
}
