package facebook;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySumK {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> sumsMap = new HashMap<Integer, Integer>() ;
        int ans = 0 ;
        for(int i=0;i<nums.length;i++){
            if(i>0)
                nums[i]+=nums[i-1] ;
            if(!sumsMap.containsKey(nums[i]))
                sumsMap.put(nums[i],i) ;
            if(sumsMap.containsKey(nums[i]) && nums[i]==k)
                ans = Math.max(ans,i+1) ;
            if(sumsMap.containsKey(nums[i]-k)){
                int prev = sumsMap.get(nums[i]-k) ;
                ans = Math.max(ans,i-prev) ;

            }
        }
        return ans ;
    }
}
