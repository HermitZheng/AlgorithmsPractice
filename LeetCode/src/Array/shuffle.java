package Array;

/**
 * @author zhuqiu
 * @date 2020/6/7
 */
public class shuffle {

    public int[] shuffle(int[] nums, int n) {
        if (nums == null || n == 0) return new int[]{};
        int[] res = new int[2*n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            res[k++] = nums[i];
            res[k++] = nums[i+n];
        }
        return res;
    }
}
