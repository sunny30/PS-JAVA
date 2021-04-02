package leetcodeuber;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> map = new HashMap<Character, Integer>() ;
        int uniqueCount = 0 ;

        int st = 0 ;
        int lt = 0 ;
        int ans = 0 ;
        while(lt<s.length()){

            if(!map.containsKey(s.charAt(lt))){
                map.put(s.charAt(lt),1) ;
                uniqueCount++ ;
            }else{
                int newVal = map.get(s.charAt(lt))+1 ;
                map.put(s.charAt(lt),newVal) ;
                if(newVal==1)
                    uniqueCount++ ;

            }

            if(uniqueCount<=k)
                ans = Math.max(ans,lt-st+1) ;
            else{
                while(uniqueCount>k){
                    int prevVal = map.get(s.charAt(st)) ;
                    int newVal = prevVal-1 ;
                    map.put(s.charAt(st),newVal) ;
                    if(newVal==0)
                        uniqueCount-- ;
                    if(uniqueCount<=k)
                        ans = Math.max(ans,lt-st) ;
                    st++ ;
                }
            }
            lt++ ;
        }
        return ans ;
    }


    public static void main(String[] args) {
        LongestSubstringWithKDistinct kDistinct = new LongestSubstringWithKDistinct() ;
        System.out.println(kDistinct.lengthOfLongestSubstringKDistinct("ab",1)) ;
    }
}
