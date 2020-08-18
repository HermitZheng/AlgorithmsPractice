package Knapsack;

/**
 * leetcode 416
 *
 * @author zhuqiu
 * @date 2020/8/11
 */
public class DivideEqualSubsets {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) return true;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i=1; i<len; i++) {
            for (int j=target; j>=nums[i]; j--) {
                if (dp[target]) return true;
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public boolean canPartition_2(int[] nums) {
        if (nums.length == 0) return true;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target+1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i=1; i<nums.length; i++) {
            if (dp[i-1][target]) return true;
            for (int j=0; j<=target; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
