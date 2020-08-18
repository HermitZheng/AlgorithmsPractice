package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author zhuqiu
 * @date 2020/6/28
 */
public class SubArrays_1 {

    public static void main(String[] args) {
        int[] nums = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        int i = new SubArrays_1().numSubseq(nums, 22);
        System.out.println(i);
    }


    public int numSubseq(int[] nums, int target) {

        // Arrays.sort(nums);

        long sum = getSubArray(nums, nums.length, target);

        return (int) (sum % (1000000007));
    }

    private long getSubArray(int[] arr, int length, int target) {
        int mark = 0;
        long sum = 0;
        long nEnd = 1 << length;
        System.out.println(nEnd);
        for (mark = 0; mark < nEnd; mark++) {
            ArrayList<Integer> aList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if ((1 << i & mark) != 0) {
                    aList.add(arr[i]);
                }
            }
            if (aList.size() == 0) continue;
            int sum_l = 0;
            sum_l += Collections.min(aList);
            sum_l += Collections.max(aList);
            if (sum_l <= target) {
                sum++;
            }
        }
        System.out.println(sum);
        return sum;
    }
}
