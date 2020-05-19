package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author zhuqiu
 * @date 2020/3/26
 */
public class KMin {

    public static void main(String[] args) {
        int[] arr1 = {45, 80, 55, 40, 42, 85};
        KMin instance = new KMin();
        ArrayList<Integer> list = instance.GetLeastNumbers_Solution(arr1, 2);
        list.forEach(integer -> System.out.println(integer));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList result = new ArrayList();
        if (input == null || input.length == 0 || k > input.length) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() > k && input[i] < maxHeap.peek()){
                maxHeap.poll();
            }
            maxHeap.offer(input[i]);
        }
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}
