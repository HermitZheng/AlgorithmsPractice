package Array;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/6/14
 */
public class RemoveNum {

    public static void main(String[] args) {
        int[] arr = {2,4,1,8,3,5,1,3};
        int res = new RemoveNum().findLeastNumOfUniqueInts(arr, 3);
        System.out.println(res);
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Comparator.comparing(Map.Entry::getValue));

        LinkedList<Map.Entry<Integer, Integer>> stack = new LinkedList<>(entries);
        while (k > 0) {
            if (map.isEmpty()) return 0;
            Map.Entry<Integer, Integer> entry = stack.pop();
            int num = entry.getValue();
            if (k < num) {  // 减不完
                return stack.size() + 1;
            }
            k -= num;
        }
        return stack.size();

//        Set<Integer> set = new HashSet<>();
//        for (int i : arr) {
//            set.add(i);
//        }
//        return set.size() - 1;
    }
}
