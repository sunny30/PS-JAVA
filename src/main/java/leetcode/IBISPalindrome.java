package leetcode;

public class IBISPalindrome {

    public Integer nextCharacter(String input,int index,boolean isreverse){
        int i = index ;
        int n = input.length() ;

        if(isreverse){
            while(i>=0 && !Character.isLetterOrDigit(input.charAt(i))){
                i-- ;
            }

        }else{
            while(i<n && !Character.isLetterOrDigit(input.charAt(i))){
                i++ ;
            }
        }
        return i ;
    }

    public Boolean isPlaindrome(String s){
        String inputLower = s.toLowerCase() ;

        int first = 0 ;
        int last = inputLower.length()-1 ;


        while(first<=last){
            first = nextCharacter(inputLower,first,false) ;
            last = nextCharacter(inputLower,last,true) ;
            Character fc = inputLower.charAt(first);
            Character lc = inputLower.charAt(last);
            if(fc.compareTo(lc)!=0)
                return false ;
            first++ ;
            last-- ;
        }
        return true ;
    }


    public static void main(String[] args) {
        IBISPalindrome palindrome = new IBISPalindrome() ;
        String input = "A man, a plan, a canal: Panama";
        String input1 = "abba";
        String input2 = "race a car" ;
        System.out.println(palindrome.isPlaindrome(input2));
    }
}
