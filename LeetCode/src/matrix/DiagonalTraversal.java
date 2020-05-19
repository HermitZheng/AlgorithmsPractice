package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/4/26
 */
public class DiagonalTraversal {

    public static void main(String[] args) {
        List<List<Integer>> arr  = new ArrayList<>();
//        new DiagonalTraversal().findDiagonalOrder()
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = nums.get(0).size();
        int[] res = new int[len * len];
        int[][] arr = new int[len][len];
        for (int i = 0; i < len; i++) {
            if (i < nums.size()) {
                List<Integer> integers = nums.get(i);
                for (int j = 0; j < len; j++) {
                    arr[i][j] = j < integers.size() ? integers.get(j) : 0;
                }
            } else {
                for (int j = 0; j < len; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        int i = 0;
        int k;
        for (int j = 0; j < len; j++) {
            for (k = 0; k <= j; k++) {
                if (arr[j-k][k] != 0) {
                    res[i++] = arr[j-k][k];
                }
            }

        }
        int l = 1;
        for (int j = len; j <= 2*(len-1); j++) {
            for (k = l; k <= j-l; k++) {
                if (arr[j-k][k] != 0) {
                    res[i++] = arr[j-k][k];
                }
            }
            l++;
        }
        int[] result = new int[i];
        for (int j = 0; j <= i-1; j++) {
            result[j] = res[j];
        }
        return result;
    }
}
