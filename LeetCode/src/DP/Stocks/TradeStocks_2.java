package DP.Stocks;

/**
 * leetcode 122
 *
 * @author zhuqiu
 * @date 2020/4/23
 */
public class TradeStocks_2 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = new TradeStocks_2().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int len = prices.length;
        int pre = prices[0], profit = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] > pre) {
                profit += prices[i] - pre;
            }
            pre = prices[i];
        }
        return profit;
    }
}
