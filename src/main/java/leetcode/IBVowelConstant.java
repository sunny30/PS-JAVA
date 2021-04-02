package leetcode;

public class IBVowelConstant {

    public Boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            return true ;
        return false ;
    }

    public Integer stringCount(String input){
        Integer ans = 0 ;
        Integer modulo = 1000000007;
        Integer vowelCount = 0 ;
        for(int i =0;i<input.length();i++){
            if(!isVowel(input.charAt(i))){
                ans += vowelCount ;
                ans = ans%modulo ;

            }else{
                ans+=(i-vowelCount);
                ans = ans%modulo ;
                vowelCount++;

            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        String inp = "aba" ;
        IBVowelConstant vowelConstant = new IBVowelConstant();

        System.out.println(vowelConstant.stringCount(inp));
    }
}
