package toptal;

import java.util.Map;
import java.util.TreeMap;

public class First {
    public String solution(String[] A, String[] B, String P) {
        // write your code in Java SE 8

        Map<String,String> map = new TreeMap<String,String>() ;
        String ans = "NO CONTACT" ;
        for(int i=0;i<A.length;i++){
            map.put(A[i],B[i]) ;
        }

        for(String key:map.keySet()){
            String phId = map.get(key) ;
            if(phId.contains(P)){
                ans = key ;
                break ;
            }
        }
        return ans ;

    }
}
