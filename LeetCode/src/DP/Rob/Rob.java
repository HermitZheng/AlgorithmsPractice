package DP.Rob;

/**
 * leetcode 198
 *
 * @author zhuqiu
 * @date 2020/5/29
 */

public class Rob {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len == 0 ? 0 : nums[len-1];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public int rob_(int[] nums) {
        int len = nums.length;

        int[][] dp = new int[len + 2][2];
        for (int i = 2; i < len + 2; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][1]) + nums[i - 2];
        }
        return Math.max(dp[len + 1][0], dp[len + 1][1]);
    }
}
