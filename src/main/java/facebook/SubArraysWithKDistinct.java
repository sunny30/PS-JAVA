package facebook;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDistinct {

    public int subarraysWithKDistinct(int[] A, int K) {

        int cnt = 0 ;
        int st = 0 ;
        int ed = 0 ;
        int ans =0 ;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(;ed<A.length;ed++){

            if(!map.containsKey(A[ed])){
                cnt++ ;
                map.put(A[ed],1) ;

                 if(cnt>K){
                    while (cnt>K){
                        int val = map.get(st)-1 ;
                        if(val==0)
                            cnt-- ;
                        map.put(A[st],val) ;
                        if(cnt==K)
                            ans++;
                        st++;
                    }


                }else{
                    int val = map.get(st)+1 ;
                    map.put(A[ed],val) ;
                    if(cnt==K)
                        ans++ ;
                }

            }


        }
        return ans ;
    }
}
