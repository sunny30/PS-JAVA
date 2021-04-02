package facebook;

public class MinimumSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        //int i=0;
        int j=-1 ;
        int ans = nums.length+1 ;
        for(int i=0;i<nums.length;i++){
            nums[i] = (i>0?(nums[i]+nums[i-1]):nums[i]) ;
            if(nums[i]-((j>=0)?nums[j]:0)>=s){
                while(j<i && (nums[i]-((j>=0)?nums[j]:0)>s)){
                    ans = Math.min(ans,i-j) ;
                    j++;
                }
                if(nums[i]-((j>=0)?nums[j]:0)==s)
                    ans = Math.min(ans,i-j) ;
            }


        }

        return ((ans>nums.length)?0:ans) ;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3} ;
        MinimumSubArrayLen minimumSubArrayLen = new MinimumSubArrayLen() ;
        System.out.println(minimumSubArrayLen.minSubArrayLen(7,nums)) ;
    }
}
