package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 378
 * 有序矩阵中第K小的元素
 *
 * @author zhuqiu
 * @date 2020/7/2
 */
public class MatrixKth {

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(value -> value[0]));
        for (int i=0; i<len; i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i=0; i<k-1; i++) {
            int[] poll = heap.poll();
            if (poll[2] < len-1) {
                heap.offer(new int[] {matrix[poll[1]][poll[2]+1], poll[1], poll[2]+1});
            }
        }

        return heap.poll()[0];
    }
}
