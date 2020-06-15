package Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhuqiu
 * @date 2020/6/14
 */
public class BloomDay {

    int[] bloomDay;
    int k;

    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) return -1;

        this.bloomDay = bloomDay;
        this.k = k;

        int[] maxValue = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && bloomDay[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(bloomDay[i]);
        }
        maxValue[0] = deque.peekFirst();

        for (int i = k; i < len; i++) {
            if (bloomDay[i - k] == deque.peekFirst()){}
        }
        return 0;
    }
}
