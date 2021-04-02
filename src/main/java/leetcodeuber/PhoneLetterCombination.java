package leetcodeuber;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {

    List<String> solution = new ArrayList<String>() ;

    public void recurKeyPad(String[] keyPad,int pos,String interim,String digits){
        if(pos==digits.length())
        {
            solution.add(interim);
            return;
        }

        int val = Integer.parseInt(String.valueOf(digits.charAt(pos))) ;
        String keyPadValue = keyPad[val-2] ;

        for(int i=0;i<keyPadValue.length();i++){
            recurKeyPad(keyPad,pos+1,interim+String.valueOf(keyPadValue.charAt(i)),digits);
        }


    }
    public List<String> letterCombinations(String digits) {
        String[] keyPad = {"abc","def","ghi","jkl","mno","pqrs","tuv","xyz"} ;

        recurKeyPad(keyPad,0,"",digits);

        return solution ;

    }

    public static void main(String[] args) {
        String input = "2" ;
        PhoneLetterCombination letterCombination = new PhoneLetterCombination() ;
        letterCombination.letterCombinations(input) ;
        for(int i=0;i<letterCombination.solution.size();i++){
            System.out.println(letterCombination.solution.get(i));
        }
    }
}
