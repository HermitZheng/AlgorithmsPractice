package Array;

import java.util.ArrayList;

/**
 * @author zhuqiu
 * @date 2020/3/11
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {  // 这tm也能过
        int rows = matrix.length;
        int cols = matrix[0].length;   // 行和列的长度，同时也代表“尾部”，即矩阵右下部分已被遍历过的位置
        if (cols == 0 || rows == 0){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int fir = 0, sec =0;      // 分别为行和列的指针
        int head1 = 0, head2 = 0;   // 行和列的“头部”，即矩阵左上部分已被遍历过的位置
        result.add(matrix[0][0]);
        if (cols == 1){
            for (fir++ ; fir >= head1 && fir < rows; fir++){  // 从该行的第二格（因此fir++）开始遍历
                result.add(matrix[fir][sec]);
            }
        }
        while (rows > 1 || cols > 1){
            int sign = 0;
            for (sec++ ; sec >= head2 && sec < cols; sec++, sign=1) {  // 当循环不进行时，sign没有被赋值，意味着遍历已经结束
                result.add(matrix[fir][sec]);
            }
            if (sign != 1){   // 遍历结束，跳出while循环
                break;
            }
            sec--;     // 用于抵消for循环最后的sec++
            cols--;    // “消除”最右边的一列

            for (fir++ ; fir >= head1 && fir < rows; fir++, sign=2){
                result.add(matrix[fir][sec]);
            }
            if (sign != 2){
                break;
            }
            fir--;
            rows--;

            for (sec-- ; sec >= head2 && sec < cols; sec--, sign=3){
                result.add(matrix[fir][sec]);
            }
            if (sign != 3){
                break;
            }
            sec++;
            head1++;

            for (fir-- ; fir >= head1 && fir < rows; fir--, sign=4){
                result.add(matrix[fir][sec]);
            }
            if (sign != 4){
                break;
            }
            fir++;
            head2++;
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int [][] matrix = {{1}, {5}, {9}};
        PrintMatrix printMatrix = new PrintMatrix();
        ArrayList<Integer> result = printMatrix.printMatrix(matrix);
        System.out.println(result);
    }
}
