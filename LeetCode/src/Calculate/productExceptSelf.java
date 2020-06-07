package Calculate;

import java.util.Arrays;

/**
 * leetcode 238
 *
 * @author zhuqiu
 * @date 2020/6/4
 */
public class productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[]{};
        int[] res = new int[len];
        int temp = 1;
        for (int i = 0; i < len; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = len-1; i >= 0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}
