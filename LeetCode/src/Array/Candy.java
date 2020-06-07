package Array;

import java.util.*;

/**
 * leetcode 1431
 *
 * @author zhuqiu
 * @date 2020/6/1
 */
public class Candy {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        List<Boolean> list = new ArrayList<>(len);
        if (len == 0) return list;

        // int max = Arrays.stream(candies).max().getAsInt();   慢
        int max = 0;
        for (int candy: candies) {
            max = Math.max(max, candy);
        }
        extraCandies = max - extraCandies;
        for (int i = 0; i < len; i++) {
            list.add(candies[i] >= extraCandies);
        }
        return list;
    }
}
