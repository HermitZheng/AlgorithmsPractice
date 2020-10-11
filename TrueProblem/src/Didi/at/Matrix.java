package Didi.at;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/21
 */
public class Matrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            return;
        }
        long[][] matrix = new long[n][n];

        spiralOrder(matrix, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void spiralOrder(long[][] matrix, int n) {

        int rows = matrix.length;
        int cols = matrix[0].length;   // 行和列的长度，同时也代表“尾部”，即矩阵右下部分已被遍历过的位置

        long[] list = new long[n * n + 1];
        int index = n * n;

        fib_for(n * n, list);

        int fir = 0, sec =0;      // 分别为行和列的指针
        int head1 = 0, head2 = 0;   // 行和列的“头部”，即矩阵左上部分已被遍历过的位置
        matrix[0][0] = list[index--];
        if (cols == 1){
            for (fir++ ; fir >= head1 && fir < rows; fir++){  // 从该行的第二格（因此fir++）开始遍历
                matrix[fir][sec] = list[index--];
            }
        }
        while (rows > 1 || cols > 1){
            int sign = 0;
            for (sec++ ; sec >= head2 && sec < cols; sec++, sign=1) {  // 当循环不进行时，sign没有被赋值，意味着遍历已经结束
                matrix[fir][sec] = list[index--];
            }
            if (sign != 1){   // 遍历结束，跳出while循环
                break;
            }
            sec--;     // 用于抵消for循环最后的sec++
            cols--;    // “消除”最右边的一列

            for (fir++ ; fir >= head1 && fir < rows; fir++, sign=2){
                matrix[fir][sec] = list[index--];
            }
            if (sign != 2){
                break;
            }
            fir--;
            rows--;

            for (sec-- ; sec >= head2 && sec < cols; sec--, sign=3){
                matrix[fir][sec] = list[index--];
            }
            if (sign != 3){
                break;
            }
            sec++;
            head1++;

            for (fir-- ; fir >= head1 && fir < rows; fir--, sign=4){
                matrix[fir][sec] = list[index--];
            }
            if (sign != 4){
                break;
            }
            fir++;
            head2++;
        }
    }


    public static void fib_for(int n, long[] list) {
        list[1] = 1;
        if (n == 1 || n == 2) {
            return;
        }
        list[2] = 1;
        int k = 3;

        long pre1 = 1;
        long pre2 = 1;
        long current = pre1 + pre2;
        for (int i = 3; i < n+1; i++) {
            current = pre1 + pre2;
            list[k++] = current;
            pre2 = pre1;
            pre1 = current;
        }
        for (long i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

//
//    public static void spiralOrder(int[][] matrix, int n) {
//
//        int[] list = new int[n * n + 2];
//        int index = n * n + 1;
//
//        fib_for(n * n, list);
//
//        int l = 0;
//        int r = matrix[0].length - 1;
//        int u = 0;
//        int d = matrix.length - 1;
//
//        while (l <= r && u <= d) {
//            for (int i = 1; i <= r; i++) {
//                matrix[u][i] = list[index--];
//            }
//            u++;
//            for (int i = u; i <= d; i++) {
//                matrix[i][r] = list[index--];
//            }
//            r--;
//            for (int i = r; i >= l && u <= d ; i--) {
//                matrix[d][i] = list[index--];
//            }
//            d--;
//            for (int i = d; i >= u && l <= r ; i--) {
//                matrix[i][l] = list[index--];
//            }
//            l++;
//        }
//    }

}
