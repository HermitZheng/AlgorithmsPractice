package MeiTuan.at;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/8/22
 */
public class Paotui {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] gets = new int[n];

        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.comparingInt(o -> -o));

        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            int weight = in.nextInt();
            int get = value + weight * 2;
            gets[i] = get;
            List<Integer> list = map.getOrDefault(get, new ArrayList<>());
            list.add(i+1);
            map.put(get, list);
        }

        Iterator<Map.Entry<Integer, List<Integer>>> entries = map.entrySet().iterator();

        int[] nums = new int[m];
        int k = 0;

        outer:
        while (entries.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = entries.next();
            List<Integer> numList = next.getValue();

            for (Integer num : numList) {
                if (k >= m) {
                    break outer;
                }
                nums[k++] = num;
            }
        }

        Arrays.sort(nums);

        boolean flag = true;
        for (int num : nums) {
            if (!flag) {
                System.out.print(" ");
            }
            System.out.print(num);
            flag = false;
        }
    }
}
