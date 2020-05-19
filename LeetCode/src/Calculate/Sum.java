package Calculate;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/12
 */
public class Sum {

    public static void main(String[] args) {
        int[] ints = new Sum().twoSum(new int[]{3, 2, 4}, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(target-nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) != i) {
                result[0] = i;
                result[1] = hashMap.get(nums[i]);
                return result;
            }
        }
        return result;
    }
}
