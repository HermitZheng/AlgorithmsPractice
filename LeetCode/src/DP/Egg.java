package DP;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/4/11
 */
public class Egg {
    public static void main(String[] args) {
        int res = new Egg().superEggDrop(3, 14);
        System.out.println(res);
    }

    public int superEggDrop(int K, int N) {    // K个鸡蛋，N层楼
        if (K == 0 || N == 0) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];    // 反了一下，N行K列
        initialize(dp, K, N);

        ONKLogN(dp, K, N);
        return dp[N][K];
    }

    public void ONKLogN(int[][] dp, int K, int N) {
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int left = 1;
                int right = i;
                while (left < right) {      // 二分查找
//                    int mid = (left + right) >>> 1;
                    int mid = left + (right - left + 1) / 2;
                    if (dp[mid-1][j-1] > dp[i-mid][j]) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.max(dp[left-1][j-1], dp[i-left][j]) + 1;
            }
        }
    }

    public void ON2K(int[][] dp, int K, int N) {
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);  // 状态转移方程
                }
            }
        }
    }

    public void initialize(int[][] dp, int K, int N) {   // 初始化，当K=0，N=0时都为0，K=1时结果为N
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = i;
            }
        }
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 0;
        }
    }


}
