package facebook;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums.length == 0)
            return;
        int start = 0;
        int last = 0;
        int cnt = 0;
        while (last < nums.length) {

            if (nums[last] != 0) {
                nums[start] = nums[last];
                start++;
            } else {
                cnt++;
            }
            last++;
        }

        for(;start<nums.length;start++){
            nums[start] = 0 ;
        }


    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        moveZeros.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
