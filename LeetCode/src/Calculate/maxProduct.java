package Calculate;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * zhousai 5424
 *
 * @author zhuqiu
 * @date 2020/5/31
 */
public class maxProduct {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2-o1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 1;
        if (map.firstEntry().getValue() >= 2) {
            sum = (map.firstKey()-1) * (map.firstKey()-1);
        } else {
            sum *= map.firstKey()-1;
            map.pollFirstEntry();
            sum *= map.firstKey()-1;
        }
        return sum;
    }
}
