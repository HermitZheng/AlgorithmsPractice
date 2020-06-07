package matrix;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/6/5
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] maxtrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[] res = new SpiralOrder().spiralOrder(maxtrix);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        int rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int r = 0, c = 0, k = 0;
        int row_up = 0, row_down = rows-1;
        int col_left = 0, col_right = cols-1;
        while (true) {
            for (; c <= col_right; c++) {
                res[k++] = matrix[r][c];
            }
            if (k == rows * cols) return res;

            r++;
            c--;
            row_up++;
            for (; r <= row_down; r++) {
                res[k++] = matrix[r][c];
            }
            if (k == rows * cols) return res;

            c--;
            r--;
            col_right--;
            for (; c >= col_left; c--) {
                res[k++] = matrix[r][c];
            }
            if (k == rows * cols) return res;

            r--;
            c++;
            row_down--;
            for (; r >= row_up; r--) {
                res[k++] = matrix[r][c];
            }
            if (k == rows * cols) return res;

            c++;
            r++;
            col_left++;
        }
    }
}
