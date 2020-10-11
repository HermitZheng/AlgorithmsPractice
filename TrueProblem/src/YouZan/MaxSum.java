package YouZan;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/8/20
 */
public class MaxSum {

    /**
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int maxSumDivFive (int[] nums) {
        // write code here
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        while (sum % 5 != 0) {
            sum--;
        }
        while (sum >= 0) {
            if (traceBack(len, 0, null, nums) == sum) {
                return sum;
            } else {
                sum -= 5;
            }
        }
        return 0;
    }

    public static int traceBack(int num, int sumWeight, int[] weight, int[] value) {
        int[] dp = new int[sumWeight+1];         // 对背包重量内所有可能的重量，建立对应的价值表

        for (int i = 0; i < num; i++) {           // 尝试将所有物品放入背包中
            for (int j = sumWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j - weight[i]] + value[i]    // 在放入当前物品 i 之前背包的最大价值，加上物品 i 的价值
                        , dp[j]);                        // 同不放入物品 i 的最大价值进行比较
            }
        }
        return dp[sumWeight];
    }

    public int method(int N, int V, int[] weight, int[] value) {
        // 代表装载第[i]件物品时，已占用的容量为[j]，此时的背包价值
        int[][] dp = new int[N+1][V+1];

        for (int i = 1; i <= N; i++) {  // 从1开始，即第i-1=0件物品
            for (int j = 0; j <= V; j++) {
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return 0;
    }
}
