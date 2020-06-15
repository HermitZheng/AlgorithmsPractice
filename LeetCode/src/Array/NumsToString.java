package Array;

import java.util.Arrays;

/**
 * leetcode MS46
 *
 * @author zhuqiu
 * @date 2020/6/9
 */
public class NumsToString {

    public int translateNum(int num) {
        char[] arr = ((Integer) num).toString().toCharArray();
        return translate(arr, 0, arr.length);
    }

    public int translate(char[] nums, int i, int len) {
        if (i >= len-1) return 1;
        if ((nums[i] == '1' && i+1 < len) || (nums[i] == '2' && i+1 < len && nums[i+1] <= '5')) {
            return translate(nums, i+1, len) + translate(nums, i+2, len);
        } else {
            return translate(nums, i+1, len);
        }
    }
}
