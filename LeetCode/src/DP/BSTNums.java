package DP;

/**
 * leetcode 96
 *
 * @author zhuqiu
 * @date 2020/5/29
 */
public class BSTNums {

    public int numTree(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n+1];    // 0个结点也算，所以有n+1
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i] = dp[j-1] * dp[i-j];      // i是当前子树的所有节点数（包括根节点），因而左右子树(i-1) + (i-j) + 1root = i
            }
        }
        return dp[n];
    }

    public int numTree_rec(int n) {
        if (n <= 1) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += numTree_rec(i-1) * numTree_rec(n-i);
        }
        return res;
    }
}
