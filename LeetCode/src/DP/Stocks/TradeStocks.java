package DP.Stocks;

import java.util.*;

/**
 * leetcode 121
 *
 * @author zhuqiu
 * @date 2020/4/22
 */
public class TradeStocks {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = new TradeStocks().maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] dp = new int[len];

        int min = prices[0];
        for(int i=1; i<len; i++) {
            int today = prices[i];
            dp[i] = Math.max(dp[i-1], today-min);
            min = Math.min(min, today);
        }
        int res = 0;
        for(int i=0; i<dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxProfit_1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] mat = new int[len][2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
//            map.put(i, prices[i]);
            mat[i][0] = prices[i];
            mat[i][1] = i;
        }
        Arrays.sort(mat, Comparator.comparingInt(o -> o[0]));
        return findMax(mat, 0, len-1);
    }

    public int findMax(int[][] mat, int i, int j) {
        if (i == j) return 0;
        if (mat[i][1] < mat[j][1]) {
            return mat[j][0] - mat[i][0];
        } else {
            return Math.max(findMax(mat, i+1, j), findMax(mat, i, j-1));
        }
    }
}
