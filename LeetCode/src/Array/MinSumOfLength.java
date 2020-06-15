package Array;


import java.util.*;

/**
 * 找两个和为目标值且不重叠的子数组
 *
 * @author zhuqiu
 * @date 2020/6/13
 */
public class MinSumOfLength {

    public static void main(String[] args) {
//        int[] arr = {78,18,1,94,1,1,1,29,58,3,4,1,2,56,17,19,4,1,63,2,16,11,1,1,2,1,25,62,10,69,12,7,1,6,2,92,4,1,61,7,26,1,1,1,67,26,2,2,70,25,2,68,13,4,11,1,34,14,7,37,4,1,12,51,25,2,4,3,56,21,7,8,5,93,1,1,2,55,14,25,1,1,1,89,6,1,1,24,22,50,1,28,9,51,9,88,1,7,1,30,32,18,12,3,2,18,10,4,11,43,6,5,93,2,2,68,18,11,47,33,17,27,56,13,1,2,29,1,17,1,10,15,18,3,1,86,7,4,16,45,3,29,2,1,1,31,19,18,16,12,1,56,4,35,1,1,36,59,1,1,16,58,18,4,1,43,31,15,6,1,1,6,49,27,12,1,2,80,14,2,1,21,32,18,15,11,59,10,1,14,3,3,7,15,4,55,4,1,12,4,1,1,53,37,2,5,72,3,6,10,3,3,83,8,1,5};
//        int[] arr = {78,18,1,94,1,1,1,29,58,3,4,1,2,56,17,19,4,1,63,2,16,11,1,1,2,1,25,62,10,69,12,7,1,6,2,92,4,1,61,7,26,1,1,1,67,26,2,2,70,25,2,68,13,4,11,1,34,14,7,37,4,1,12,51,25,2,4,3,56,21,7,8,5,93,1,1,2,55,14,25,1,1,1,89,6,1,1,24,22,50,1,28,9,51,9,88};
        int[] arr = {1, 6, 1};
        int res = new MinSumOfLength().minSumOfLengths(arr, 7);
        System.out.println(res);
    }

    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) return -1;

        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (arr[i] > target) continue;
            if (arr[i] == target) {
                map.put(new ArrayList<>(Arrays.asList(new Integer[]{i})), 1);
                continue;
            }
            int temp = arr[i];
            int count = 1;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            for (int j = i + 1; j < len; j++) {
                temp += arr[j];
                list.add(j);
                count++;
                if (temp > target) break;
                if (temp == target) {
                    map.put(list, count);
                    break;
                }
            }
        }
        ArrayList<Map.Entry<ArrayList<Integer>, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Comparator.comparing(Map.Entry::getValue));

        int res = 0;
        int count = 2;
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<ArrayList<Integer>, Integer> entry : entries) {
            Set<Integer> temp = new HashSet<>(set);
            temp.retainAll(entry.getKey());
            if (temp.size() == 0) {
                res += entry.getValue();
                count--;
                set.addAll(entry.getKey());
            }
            if (count == 0) return res;
        }
        return -1;
    }
}
