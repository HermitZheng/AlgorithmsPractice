package NetEase.HuYu.at;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/9/14
 */
public class Demo {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] nums = {2, 3, 1, 1, 5, 4, 5};
        List<int[]> res = method(nums, 6);
        for (int[] a: res) {
            System.out.println(a[0] + " " + a[1]);
        }
    }

    public static List<int[]> method(int[] nums, int target) {
        List<int[]> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num: nums) {
            map.put(num, map.get(num)-1);
            if (map.containsKey(target-num) && map.get(target-num) > 0) {
                for (int i=0; i<map.get(target-num); i++) {
                    res.add(new int[]{num, target-num});
                }
            }
        }

        return res;
    }
}