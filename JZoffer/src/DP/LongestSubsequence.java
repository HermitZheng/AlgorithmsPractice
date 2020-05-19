package DP;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/4/10
 */
public class LongestSubsequence {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int max = dp(nums);
        System.out.println(max);
    }

    public static int dp(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }
}
