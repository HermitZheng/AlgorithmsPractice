package Matrix;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/3/24
 */
public class FindMax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        int max = Math.max(findMaxLeftDiagonal(arr, n, d), findMaxRowCol(arr, n, d));
        System.out.println(max);
    }

    public static int findMaxRowCol(int[][] arr, int n, int d) {
        if (arr[0].length == 0) {
            return 0;
        }
        int max = arr[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - d + 1; j++) {
                int temp1, temp2;
                temp1 = temp2 = 0;
                for (int k = j; k < j + d; k++) {
                    temp1 += arr[i][k];
                    temp2 += arr[k][i];
                }

                if (temp1 > max || temp2 > max) {
                    max = Math.max(temp1, temp2);
                }
            }
        }
        return max;
    }

    public static int findMaxLeftDiagonal(int[][] arr, int n, int d) {
        if (arr[0].length == 0) {
            return 0;
        }
        int max = arr[0][0];
        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {
                int temp1, temp2;
                temp1 = temp2 = 0;

                for (int j = 0; j < d; j++) {
                    if (i + j < n && i + j + k < n) {
                        temp1 += arr[i + j][i + k + j];
                    }
                    if (i - j >= 0 && i + k - j < n) {
                        temp2 += arr[i - j][i + k - j];
                    }
                }

                if (temp1 > max || temp2 > max) {
                    max = Math.max(temp1, temp2);
                }
            }

        }
        return max;
    }
}
