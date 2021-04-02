package facebook;

public class MaximunSubsetSum {

    public int maxSubArray(int[] nums) {
        int len = nums.length ;
        int tempSum = nums[0] ;
        int mxSum = tempSum ;
        for(int i=1;i<len;i++){
            if(tempSum<0)
                tempSum = nums[i] ;
            else
                tempSum+=nums[i] ;
            mxSum = Math.max(mxSum,tempSum) ;
        }
        return mxSum ;
    }
}
