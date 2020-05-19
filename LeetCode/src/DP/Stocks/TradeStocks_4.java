package DP.Stocks;

/**
 * leetcode 188
 *
 * @author zhuqiu
 * @date 2020/4/24
 */
public class TradeStocks_4 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = new TradeStocks_4().maxProfit(2, prices);
        System.out.println(res);
    }

    public int maxProfit_dp(int max_k, int[] prices) {
        if (prices == null) return 0;
        int len = prices.length;
        if (len <= 1) return 0;
        int[][][] dp = new int[len + 1][max_k + 1][2];

        for (int k = 0; k <= max_k; k++) {
            dp[1][k][1] = Integer.MIN_VALUE;
            dp[0][k][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]); // 买入的时候算消耗一次交易数
            }
        }
        return dp[len][max_k][0];
    }

    public int maxProfit(int max_k, int[] prices) {
        if (prices == null) return 0;
        int len = prices.length;
        if (len <= 1) return 0;
        if (max_k > len / 2) {
            return maxProfit_inf(prices);
        }
        int[][][] dp = new int[len + 1][max_k + 1][2];

        for (int k = 0; k <= max_k; k++) {
            dp[0][k][1] = Integer.MIN_VALUE;
            dp[1][k][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]); // 买入的时候算消耗一次交易数
            }
        }
        return dp[len][max_k][0];
    }

    public int maxProfit_inf(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int pre = prices[0], sum = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > pre) {
                sum += prices[i] - pre;
            }
            pre = prices[i];
        }
        return sum;
    }
}
