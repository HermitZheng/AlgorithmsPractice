package NetEase.huyu;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/11
 */
public class WrongArr {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> valMap = new TreeMap<>();
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            int[] V = new int[n];
            for (int j = 0; j < n; j++) {
                V[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                valMap.put(arr[j], V[j]);
            }
            ArrayList<Map.Entry<Integer, Integer>> valList = new ArrayList<>(valMap.entrySet());
            int result = getSum(arr, valList);
            System.out.println(result);
        }
    }

    public static int getSum(int[] arr, ArrayList<Map.Entry<Integer, Integer>> valueMap) {
        int sum = 0;
        valueMap.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int len = arr.length;
        int[] wrong = new int[len];
        Arrays.sort(arr);
        ArrayList<Integer> arrayList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            arrayList.add(i, arr[i]);
        }
        int sign = -1;
        int temp;
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            Map.Entry<Integer, Integer> entry = valueMap.get(i);
            int value = entry.getValue();
            int num = entry.getKey();
            for (int j = 0; j < arrayList.size(); j++) {
                int x = arrayList.get(j);
                if ((temp = Math.abs(x - num)) < min && x != num) {
                    sign = j;
                    min = temp;
                }
            }
            wrong[i] = arrayList.get(sign);
            arrayList.remove(sign);
            sum += Math.abs(num - wrong[i]) * value;
        }
        return sum;
    }
}
