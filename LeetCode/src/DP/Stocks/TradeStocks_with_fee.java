package DP.Stocks;

/**
 * leetcode 714
 *
 * @author zhuqiu
 * @date 2020/4/24
 */
public class TradeStocks_with_fee {

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int res = new TradeStocks_with_fee().maxProfit(prices, 2);
        System.out.println(res);
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[][] dp = new int[len+1][2];
        dp[0][1] = Integer.MIN_VALUE / 2;
        dp[1][1] = - prices[0];

        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
        }

        return dp[len][0];
    }
}
