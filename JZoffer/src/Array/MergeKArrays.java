package Array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhuqiu
 * @date 2020/9/27
 */
public class MergeKArrays {

    class Element {
        int row, col, val;

        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public int[] merge(int[][] arr) {
        if (arr == null) {
            return new int[]{};
        }
        Queue<Element> heap = new PriorityQueue<>(Comparator.comparingInt(Element::getVal));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 0) {
                Element e = new Element(i, 0, arr[i][0]);
                heap.add(e);
                sum += arr[i].length;
            }
        }
        int[] res = new int[sum];
        int k = 0;

        while (!heap.isEmpty()) {
            Element poll = heap.poll();
            res[k++] = poll.getVal();
            if (poll.col + 1 < arr[poll.row].length) {
                heap.add(new Element(poll.row, poll.col+1, arr[poll.row][poll.col+1]));
            }
        }
        return res;
    }
}
