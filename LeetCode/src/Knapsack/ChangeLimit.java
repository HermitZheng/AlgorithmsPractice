package Knapsack;

/**
 * @author zhuqiu
 * @date 2020/10/9
 */

public class ChangeLimit {

    public static void main(String[] args) {
        int amount = 15;
        int[] coins = {1, 2, 5};
        int[] nums = {1, 2, 2};

        int res = new ChangeLimit().test(amount, coins, nums);
        System.out.println(res);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin: coins) {
            for (int i=coin; i<=amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public int test(int amount, int[] coins, int[] nums) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int i=0; i<coins.length; i++) {
            int coin = coins[i];
            for (int j = nums[i]; j >= 0; j--) {
                coin *= j;
                for (int k = amount; k >= coin ; k--) {
                    dp[k] += dp[k-coin];
                }
            }
        }
        return dp[amount];
    }
}
