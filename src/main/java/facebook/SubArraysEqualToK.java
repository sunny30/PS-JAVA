package facebook;

import java.util.HashMap;
import java.util.Map;

public class SubArraysEqualToK {


    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>() ;
        int ans = 0 ;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[i]==k)
                    ans++ ;
                map.put(nums[i],1) ;
            }else if(i>0){
                nums[i]+=nums[i-1] ;
                if(nums[i]==k)
                    ans++ ;
                if(map.containsKey(nums[i]-k)){
                    ans+=map.get(nums[i]-k) ;
                }
                if(!map.containsKey(nums[i])){
                    map.put(nums[i],1) ;
                }else{
                    map.put(nums[i],map.get(nums[i])+1) ;
                }
            }
        }
        return ans ;
    }
}
