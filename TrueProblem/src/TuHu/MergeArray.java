package TuHu;

/**
 * @author zhuqiu
 * @date 2020/9/10
 */
public class MergeArray {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array1 int整型一维数组
     * @param n      int整型
     * @param array2 int整型一维数组
     * @param m      int整型
     * @return int整型一维数组
     */
    public int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        // write code here
        if (n == 0) {
            return array2;
        }
        if (m == 0) {
            return array1;
        }
        int[] res = new int[n + m];

        int i = 0, j = m - 1, k = 0;

        while (i < n && j >= 0) {
            if (array1[i] <= array2[j]) {
                res[k++] = array1[i++];
            } else {
                res[k++] = array2[j--];
            }
        }
        while (i < n) {
            res[k++] = array1[i++];
        }
        while (j >= 0) {
            res[k++] = array2[j--];
        }
        return res;
    }
}
