package facebook.stack;

import java.util.Stack;

public class ValidSubArrays {

    class VX{
        int val ;
        int index ;
        VX(int val,int index){
            this.val = val ;
            this.index = index ;
        }
    }
    public int validSubarrays(int[] nums) {

        Stack<VX> stack = new Stack<VX>() ;
        stack.push(new VX(nums[0],0)) ;
        int ans = 0 ;
        for(int i=1;i<nums.length;i++){
            int cnt = 0 ;
            VX l = null ;
            while (!stack.isEmpty() && stack.peek().val>nums[i]){
                VX current = stack.pop() ;
                if(l==null)
                    l = current ;
                ans = ans+l.index-current.index+1 ;
                cnt++ ;
            }
            stack.push(new VX(nums[i],i)) ;
           // ans=ans + (cnt*(cnt+1))/2 ;
        }
        VX last = null ;
        while (!stack.isEmpty()){
            VX peek = stack.pop() ;
            if(last!=null){
                ans = ans +(last.index-peek.index)+1 ;
            }else{
                last = peek ;
                ans = ans+nums.length-last.index ;
            }
        }

        return ans ;

    }

    public static void main(String[] args) {
        ValidSubArrays validSubArrays = new ValidSubArrays() ;
        int[] nums = {1,4,2,5,3} ;
        int[] nums1 = {2,2,2} ;
        int[] nums2 = {3,2,1} ;
        int[] nums3 = {1,4,5,2,5,3} ;
        int[] nums4 = {14,20,5,13,18,8,2,14,3,13} ;
        System.out.println(validSubArrays.validSubarrays(nums4)) ;
    }
}
