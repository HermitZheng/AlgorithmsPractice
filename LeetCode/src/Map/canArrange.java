package Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuqiu
 * @date 2020/6/28
 */
public class canArrange {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        boolean b = new canArrange().canArrange(arr, 5);
        System.out.println(b);
    }

    public boolean canArrange(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<arr.length; i++) {
            // arr[i] = Math.abs(arr[i]);
            arr[i] %= k;
            if (arr[i] < 0) arr[i] += k;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] temp = new int[100000];
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            temp[entry.getKey()] = entry.getValue();
//        }

        for (Integer key : map.keySet()) {
            temp[key] = map.get(key);
        }

        for (int i = 1; i < k; i++) {
            if (temp[i] != temp[k-i]) {
                return false;
            }
        }
        return true;
    }
}
