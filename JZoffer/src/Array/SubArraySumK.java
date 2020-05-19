package Array;

import java.util.HashMap;

/**
 * @author zhuqiu
 * @date 2020/5/15
 */
public class SubArraySumK {

    public static void main(String[] args) {
        int[] nums = {28,54,7,-70,22,65,-6};
        int res = new SubArraySumK().subarraySum(nums, 100);
        System.out.println(res);
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int now = 0, count = 0;
        for (int i=0; i<len; i++) {
            now += nums[i];
            // now-k 相当于当前和减去pre：now-k == pre; 即 now-pre == k
            if (map.containsKey(now-k)) {   // 当前的和now加上nums[i]后，减去k能在map中找到，即pre出现在map（数组）中
                count += map.get(now-k);
            }
            map.put(now, map.getOrDefault(now, 0) + 1);
        }
        return count;
    }
}
