package Knapsack;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/8/11
 */
public class CoinsChange {

    public int coinChange(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
