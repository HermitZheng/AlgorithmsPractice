package matrix;

/**
 * leetcode 221
 *
 * @author zhuqiu
 * @date 2020/5/9
 */
public class LargestSquare {

    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];

        int max = 0;
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (i-1 < 0 || j-1 < 0 || matrix[i][j] == '0') dp[i][j] = Integer.parseInt(matrix[i][j]+"");
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }

//        for (int i=0; i<height; i++) {
//            for (int j=0; j<width; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return max * max;
    }
}
