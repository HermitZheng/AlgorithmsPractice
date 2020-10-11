package Heap;

import java.util.*;

/**
 * leetcode 347
 *
 * @author zhuqiu
 * @date 2020/5/11
 */
public class TopK {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 创建hashmap，记录字符值，以及其频率
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {

        }

        // 初始化堆，记录最不频繁的元素
        PriorityQueue<Integer> heap =   //(n1, n2) -> countMap.get(n1) - countMap.get(n2)
                new PriorityQueue<Integer>(Comparator.comparingInt(countMap::get));

        for (int num: countMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> top_k = new LinkedList<>();
        while (!heap.isEmpty()) {
            top_k.add(heap.poll());
        }
        Collections.reverse(top_k);
        Integer[] integers = heap.toArray(new Integer[k]);
        int[] res = new int[k];
        res = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return top_k;
    }
}
