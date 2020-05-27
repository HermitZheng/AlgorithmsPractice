package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * leetcode 974
 *
 * @author zhuqiu
 * @date 2020/5/27
 */
public class SubarraysDivByK {

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int res = new SubarraysDivByK().subarraysDivByK(nums, 5);
        System.out.println(res);
    }

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            int mod = (sum % K + K) % K;  // +K是为了抵消负号
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
//        AtomicInteger count = new AtomicInteger();
//        map.forEach((k, v) -> count.getAndAdd((v * (v - 1)) / 2));        // 排列组合计算count
//        return count.get;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return count;
    }
}
