package facebook;

public class FirstMissingPositive {

    public void dfs(int[] nums,int index){
        int t = nums[nums[index]] ;
        nums[index] = index ;
        if(t>=0 && t<nums.length && t!=nums[t]){
            dfs(nums,t);
        }
    }
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i && nums[i]>=0 && nums[i]<nums.length)
                dfs(nums,i) ;
        }
        int ans =1 ;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=i)
                ans =  i ;
        }
        return  ans ;
    }
}
