package Array;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/6/7
 */
public class Strongest {

    public int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        if (k == 0 || len == 0) return new int[]{};
        int[] sorted = Arrays.copyOf(arr, len);
        Arrays.sort(sorted);
        int mid = sorted[(len - 1) / 2];
        int[] strong = new int[k];
        int left = 0, right = len-1;
        int i = 0;
        while (left <= right && i < k) {
            if (Math.abs(sorted[right] - mid) > Math.abs(sorted[left] - mid)
                    || (Math.abs(sorted[right] - mid) == Math.abs(sorted[left] - mid) && sorted[right] > sorted[left])) {
                strong[i++] = sorted[right--];
            } else {
                strong[i++] = sorted[left++];
            }
        }
        return strong;
    }
}
