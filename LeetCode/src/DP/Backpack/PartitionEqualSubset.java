package DP.Backpack;

import java.util.Arrays;

/**
 * leetcode 416 分割等和子集
 *
 * @author zhuqiu
 * @date 2020/7/28
 */
public class PartitionEqualSubset {

    public boolean _canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int len = nums.length;
        if (len == 0 || (sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;

        // dp中存放的是，对于第i个物品，放[i-1][j-nums[i]]，或者不放[i-1][j]时，能否塞满（等于j）
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (dp[target]) return true;
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        /*
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
         */
        int len = nums.length;
        if (len == 0 || (sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;

        // dp中存放的是，对于第i个物品，放[i-1][j-nums[i]]，或者不放[i-1][j]时，能否塞满（等于j）
        boolean[][] dp = new boolean[len][target+1];
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        } else {
            return false;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
//                if (nums[i] == j) {       // 上面的dp[0][0]=true 可以省去这里
//                    dp[i][j] = true;
//                    continue;
//                }
                if (nums[i] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
            if (dp[len-1][target]) return true;
        }
        return dp[len-1][target];
    }
}
