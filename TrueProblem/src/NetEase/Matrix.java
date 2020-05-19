package NetEase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class Matrix {

    static int[][] res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
                res[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int result = find(matrix, i, j, n, m);
                System.out.print(result+" ");
            }
            System.out.println();
        }


    }

    public static int find(int[][] matrix, int i, int j, int n, int m) {
        int num = res[i][j];
        if (num != -1) {
            return num;
        }
        if (matrix[i][j] == 0) {
            res[i][j] = 0;
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        if (i == 0 && j == 0) {
            arrayList.add(find(matrix, i+1, j, n, m));
            arrayList.add(find(matrix, i+1, j+1, n, m));
            arrayList.add(find(matrix, i, j+1, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;
            return result;
        }

        if (i == n-1 && j == m-1){
            arrayList.add(find(matrix, i-1, j, n, m));
            arrayList.add(find(matrix, i-1, j-1, n, m));
            arrayList.add(find(matrix, i, j-1, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;
            return result;
        }

        if (i == n-1 && j == 0) {
            arrayList.add(find(matrix, i-1, j, n, m));
            arrayList.add(find(matrix, i-1, j+1, n, m));
            arrayList.add(find(matrix, i, j+1, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;

            return result;
        }

        if (i == 0 && j == m-1) {
            arrayList.add(find(matrix, i, j-1, n, m));
            arrayList.add(find(matrix, i+1, j-1, n, m));
            arrayList.add(find(matrix, i+1, j, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;

            return result;
        }

        if (i == 0) {
            arrayList.add(find(matrix, i, j-1, n, m));
            arrayList.add(find(matrix, i, j+1, n, m));
            arrayList.add(find(matrix, i+1, j-1, n, m));
            arrayList.add(find(matrix, i+1, j, n, m));
            arrayList.add(find(matrix, i+1, j+1, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;

            return result;
        }

        if (j == 0) {
            arrayList.add(find(matrix, i-1, j, n, m));
            arrayList.add(find(matrix, i+1, j, n, m));
            arrayList.add(find(matrix, i-1, j+1, n, m));
            arrayList.add(find(matrix, i, j+1, n, m));
            arrayList.add(find(matrix, i+1, j+1, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;

            return result;
        }

        if (i==n-1) {
            arrayList.add(find(matrix, i, j-1, n, m));
            arrayList.add(find(matrix, i, j+1, n, m));
            arrayList.add(find(matrix, i-1, j-1, n, m));
            arrayList.add(find(matrix, i-1, j, n, m));
            arrayList.add(find(matrix, i-1, j+1, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;

            return result;
        }

        if (j==m-1) {
            arrayList.add(find(matrix, i-1, j, n, m));
            arrayList.add(find(matrix, i+1, j, n, m));
            arrayList.add(find(matrix, i-1, j-1, n, m));
            arrayList.add(find(matrix, i, j-1, n, m));
            arrayList.add(find(matrix, i+1, j-1, n, m));
            Collections.sort(arrayList);
            int result = arrayList.get(0)+1;
            res[i][j] = result;

            return result;
        }

        arrayList.add(find(matrix, i-1, j-1, n, m));
        arrayList.add(find(matrix, i-1, j, n, m));
        arrayList.add(find(matrix, i-1, j+1, n, m));
        arrayList.add(find(matrix, i, j-1, n, m));
        arrayList.add(find(matrix, i, j+1, n, m));
        arrayList.add(find(matrix, i+1, j-1, n, m));
        arrayList.add(find(matrix, i+1, j, n, m));
        arrayList.add(find(matrix, i+1, j+1, n, m));
        Collections.sort(arrayList);
        int result = arrayList.get(0)+1;
        res[i][j] = result;
        return result;
    }
}
