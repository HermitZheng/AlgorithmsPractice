package Array;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/9/7
 */
public class MergeArray {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int k = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num: nums1) {
            set1.add(num);
        }
        for (int num: nums2) {
            if (set1.contains(num) && !set2.contains(num)) {
                res[k++] = num;
                set2.add(num);
            }
        }
        return Arrays.copyOf(res, k);
    }
}
