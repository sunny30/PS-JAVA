package facebook;

public class NextPermutation {

    void reverse(int[] nums,int st,int ed){
        while(st<ed){
            int temp =nums[ed] ;
            nums[ed] = nums[st] ;
            nums[st] = temp ;
            st++;ed-- ;
        }
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length ;
        int i = len-1 ;
        boolean found = false ;
        while (i>0){
            if(nums[i]<=nums[i-1]){
                i-- ;
            }else{
                break ;
            }
        }
        if(i>0){
            int j=nums.length-1 ;
            while(j>=i){
                if(nums[j]<=nums[i-1])
                    j-- ;
                else
                    break;
            }
            int temp = nums[j] ;
            nums[j] = nums[i-1] ;
            nums[i-1] = temp ;
            reverse(nums,i,len-1);
        }else{
            reverse(nums,0,len-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1} ;
        NextPermutation permutation = new NextPermutation() ;
        permutation.nextPermutation(nums);
        System.out.println(nums);
    }
}
