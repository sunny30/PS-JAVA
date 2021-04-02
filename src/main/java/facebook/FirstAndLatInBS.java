package facebook;

public class FirstAndLatInBS {

    private int loweBound(int[] nums,int target){
        int start = 0 ;
        int last = nums.length-1 ;
        int res = -1 ;
        while(start<=last){
            int mid = (start+last)/2 ;
            if(nums[mid]==target){
                res = mid ;
                last = mid-1 ;
            }else if(nums[mid]<target){
                start = mid+1 ;
            }else{
                last=mid-1 ;
            }
        }
        return res ;
     }

    private int upperBound(int[] nums,int target){
        int start = 0 ;
        int last = nums.length-1 ;
        int res = -1 ;
        while(start<=last){
            int mid = (start+last)/2 ;
            if(nums[mid]==target){
                res = mid ;
                start = mid+1 ;
            }else if(nums[mid]<target){
                start = mid+1 ;
            }else{
                last=mid-1 ;
            }
        }
        return res ;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2] ;
        int lower = loweBound(nums,target) ;
        int upper = upperBound(nums,target) ;
        ans[0] = lower ;ans[1] = upper ;
        return ans ;
    }

    public static void main(String[] args) {
        FirstAndLatInBS bs = new FirstAndLatInBS() ;
        int[] num = {5,7,7,8,8,10};int target = 8 ;
        int[] num1 = {5,7,7,8,8,10} ;int target1 = 6 ;
        int [] nums2 = {} ;int target2 = 3 ;

        System.out.println(bs.searchRange(num,target)[0]+" "+bs.searchRange(num,target)[1]) ;
        System.out.println(bs.searchRange(num1,target1)[0]+" "+bs.searchRange(num1,target1)[1]) ;
        System.out.println(bs.searchRange(nums2,target2)[0]+" "+bs.searchRange(nums2,target2)[1]) ;

    }
}
