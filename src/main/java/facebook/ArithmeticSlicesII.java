package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArithmeticSlicesII {

    public int numberOfArithmeticSlices(int[] A) {
        List<HashMap<Integer, Integer>> dp = new ArrayList<HashMap<Integer, Integer>>();

        for (int i = 0; i < A.length; i++) {
            dp.add(new HashMap<Integer, Integer>());
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {

                int diff = A[i] - A[j];
                if (!dp.get(j).containsKey(diff)) {
                    dp.get(i).put(diff, 2);
                } else {
                    dp.get(i).put(diff, dp.get(j).get(diff) + 1);
                }

            }
        }

        int ans = 0 ;

        for(int i=0;i<A.length;i++){
            for(Integer key: dp.get(i).keySet()){
                if(dp.get(i).get(key)>2)
                    ans = ans + dp.get(i).get(key)-2 ;
            }
        }

        return ans ;
    }

    public static void main(String[] args) {
        ArithmeticSlicesII arithmeticSlicesII = new ArithmeticSlicesII() ;
        int[] input = {2, 4, 6, 8, 10} ;
        System.out.println(arithmeticSlicesII.numberOfArithmeticSlices(input) );
    }


}
