package DP;

/**
 * @author zhuqiu
 * @date 2020/6/27
 */
public class LongestAfterDel {

    public int longestSubarray(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = -1;

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] == 1) {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = dp[i-1][0];
            }
        }
        int max = 0;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(dp[i][1], max);
        }
        return max;
    }
}
