package DP.Rob;

/**
 * leetcode 213
 *
 * @author zhuqiu
 * @date 2020/5/29
 */
public class Rob_2 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len == 0 ? 0 : nums[len-1];
        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<len-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int max = dp[len-2];

        dp[0] = 0;
        dp[1] = nums[1];
        for (int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return Math.max(dp[len-1], max);
    }
}
