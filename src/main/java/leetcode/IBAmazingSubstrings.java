package leetcode;

public class IBAmazingSubstrings {

    public Boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            return true ;
        return false ;
    }

    public Integer stringCount(String input){
        input = input.toLowerCase() ;
        Integer ans = 0 ;
        Integer modulo = 10003;
        Integer vowelCount = 0 ;
        for(int i =0;i<input.length();i++){
            if(!isVowel(input.charAt(i))){
                ans += vowelCount ;
                ans = ans%modulo ;

            }else{
                vowelCount++;
                ans+=(vowelCount);
                ans = ans%modulo ;
                //vowelCount++;

            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        IBAmazingSubstrings substrings = new IBAmazingSubstrings() ;
        System.out.println(substrings.stringCount("ABEC")) ;
    }
}
