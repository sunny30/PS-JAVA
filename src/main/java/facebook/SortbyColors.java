package facebook;

public class SortbyColors {
    public void sortColors(int[] nums) {
        int zeroPos = 0 ;
        int twoPos = nums.length-1 ;
        int i = 0;
        while (i< nums.length){

            if(nums[i]==0){
                int  temp = nums[zeroPos] ;
                nums[zeroPos] = nums[i] ;
                nums[i] = temp ;
                zeroPos++ ;
                i++ ;
            }else if(nums[i]==2 && i<twoPos){
                int temp = nums[twoPos] ;
                nums[twoPos] = nums[i] ;
                nums[i] = temp ;
                twoPos-- ;
            }else{
                i++ ;
            }

        }
    }

    public static void main(String[] args) {
        SortbyColors sortbyColors = new SortbyColors() ;
        int[] nums = {2,1,2,0,0};
        int[] nums1 = {1,2,1,0,1};
        sortbyColors.sortColors(nums);
        for(int i =0 ;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
