package DP.Stocks;

/**
 * leetcode 309
 *
 * @author zhuqiu
 * @date 2020/4/24
 */
public class TradeStocks_with_freeze {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int res = new TradeStocks_with_freeze().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[][] dp = new int[len + 2][2];

        dp[0][1] = Integer.MIN_VALUE;
        dp[1][1] = Integer.MIN_VALUE;
        dp[2][1] = -prices[0];

        for (int i = 2; i <= len + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 2]);
        }

        return dp[len + 1][0];
    }
}
