package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithmeticSubSequence {

    public int longestArithSeqLength(int[] A) {
        List<Map<Integer, Integer>> dp = new ArrayList<Map<Integer, Integer>>() ;

        for(int i=0;i<A.length;i++){
            dp.add(new HashMap<Integer, Integer>());
        }
        int ans = 0 ;
        for(int i = 1;i<A.length;i++){
            for(int j=0;j<i;j++){
                int diff = A[i]-A[j] ;
                if(!dp.get(j).containsKey(diff)){
                    dp.get(i).put(diff,2) ;
                }else{
                    int tans = 1+dp.get(j).get(diff) ;
                    if(dp.get(i).containsKey(diff)){
                        tans = Math.max(tans,dp.get(i).get(diff)) ;
                        dp.get(i).put(diff,tans) ;
                    }else{
                        dp.get(i).put(diff,tans) ;
                    }
                    ans =Math.max(ans,tans) ;
                }
            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        LongestArithmeticSubSequence arithmeticSubSequence = new LongestArithmeticSubSequence() ;
        int[] input = {20,1,15,3,10,5,8} ;
        System.out.println(arithmeticSubSequence.longestArithSeqLength(input)) ;
    }
}
