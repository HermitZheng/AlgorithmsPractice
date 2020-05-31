package Area;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 94
 * 单调栈！！！
 *
 * @author zhuqiu
 * @date 2020/5/30
 */
public class largestRectangle {

    public static void main(String[] args) {
        int[] heights = {3, 6, 5, 7, 4, 8, 1, 0};
        int res = new largestRectangle().largestRectangleArea(heights);
        System.out.println(res);
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int max = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] > heights[i]) {
                int out = deque.pop();
                max = Math.max(max, heights[out] * (i - left[out]));
            }
            left[i] = deque.isEmpty() ? 0 : deque.peek() + 1;
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            int out = deque.pop();
            max = Math.max(max, heights[out] * (len - left[out]));
        }
        return max;
    }
}
