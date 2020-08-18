package Array;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/7/30
 */
public class AppearHalf {

    public int MooreVote(int[] nums) {
        int vote = 0, card = -1;

        return card;
    }

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
