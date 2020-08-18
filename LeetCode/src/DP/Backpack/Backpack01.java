package DP.Backpack;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/7/27
 */
public class Backpack01 {


    public int method() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), V = in.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        for (int i = 0; i<N; i++) {
            value[i] = in.nextInt();
            weight[i] = in.nextInt();
        }

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
        System.out.println(dp[N-1][V]);
        return dp[N-1][V];
    }
}
