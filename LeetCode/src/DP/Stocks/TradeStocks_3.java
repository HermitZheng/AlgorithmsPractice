package DP.Stocks;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/4/23
 */
public class TradeStocks_3 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = new TradeStocks_3().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit_dp(int[] prices) {
        if(prices.length <= 1) return 0;
        int max_k = 2, len = prices.length;
        int[][][] dp = new int[len+1][max_k+1][2];
        for (int k = 1; k <= max_k; k++) {
//            dp[1][k][0] = 0;
            dp[1][k][1] = Integer.MIN_VALUE;
            dp[0][k][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= len; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i-1]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i-1]);
            }
        }
        return dp[len][max_k][0];
    }

    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;

        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;

        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, - price);
        }
        return dp_i20;
    }
}
