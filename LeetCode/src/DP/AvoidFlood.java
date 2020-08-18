package DP;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/6/21
 */
public class AvoidFlood {

    public static void main(String[] args) {
        int[] rains = {1,2,0,2,3,0,1};
        int[] result = new AvoidFlood().avoidFlood(rains);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] res = new int[len];
        Map<Integer, Integer> list = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int rain : rains) {
            list.put(rain, list.getOrDefault(rain, 0)+1);
            stack.push(rain);
        }

        for (int i = len-1; i >= 0; i--) {
            int lake = rains[i];
            if (lake != 0) {
                if (map.containsKey(lake) && map.get(lake) == 1) return new int[]{};
                map.put(lake, 1);
                res[i] = -1;
            } else {    // 抽水
                if (stack.isEmpty()) {
                    res[i] = 1;
                    continue;
                }
                Integer pop = stack.pop();  // 最近的湖泊
                while (!stack.isEmpty() && (pop == 0 || list.get(pop) == 1)) pop = stack.pop();
//                if (!map.containsKey(pop)) res[i] = 1;
//                else {
                    res[i] = pop;
                    if (map.containsKey(pop)) {
                        map.put(pop, map.get(pop)-1);
                    }
//                }
            }
        }
        return res;
    }
}
