package facebook;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return true;

        boolean[] dp = new boolean[len];

        int st = len - 2;
        for (; st >= 0; st--) {
            if (st == len - 2) {
                if (nums[st] >= 1)
                    dp[st] = true;
                else
                    dp[st] = false;
            } else {
                if (nums[st] >= len - 1 - st)
                    dp[st] = true;
                else if (nums[st] == 0)
                    dp[st] = false;
                else
                    for (int i = 1; i <= nums[st]; i++) {
                        if (st+i<len && dp[st + i] == true) {
                            dp[st] = true;
                            break;
                        }

                    }
            }
        }
        return dp[0] ;
    }
}
