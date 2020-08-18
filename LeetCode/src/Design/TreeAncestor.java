package Design;

/**
 * leetcode 1483
 *
 * @author zhuqiu
 * @date 2020/6/14
 */
public class TreeAncestor {

    public static void main(String[] args) {
    }

    int[][] dp;
    int n;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][(int)(Math.log(n) / Math.log(2)) +1];
        for(int i = 0;i<n;i++) {
            dp[i][0] = parent[i];
        }
        for(int j =1;(1<<j) < n;j++) {
            for(int i=0;i<n;i++) {
                if(dp[i][j-1] != -1) {
                    dp[i][j] = dp[dp[i][j-1]][j-1];
                }
                else dp[i][j] = -1;
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k == 0 || node == -1) return node;
        int p = (int) (Math.log(k) / Math.log(2));
        return getKthAncestor(dp[node][p], k - (1<<p));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */