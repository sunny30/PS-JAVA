package leetcodeuber;

import java.util.HashMap;
import java.util.Map;

public class CanConstructKPalindrome {

    public boolean canConstruct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1) ;
            else
                map.put(s.charAt(i),map.get(s.charAt(i))+1) ;
        }
        int oddCount =0 ;
        for(Character c : map.keySet()){
            if(map.get(c)%2==1)
                oddCount++ ;


        }

        return oddCount<=k && s.length()>=k ;
    }
}
