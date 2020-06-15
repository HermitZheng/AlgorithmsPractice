package Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 739
 *
 * @author zhuqiu
 * @date 2020/6/11
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 0) return new int[]{};
        Deque<Integer> deque = new LinkedList<>();  // 单调栈
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && T[i] > T[deque.peek()]) {
                Integer index = deque.pop();
                res[index] = i-index;
            }
            deque.push(i);
        }
        return res;
    }
}
