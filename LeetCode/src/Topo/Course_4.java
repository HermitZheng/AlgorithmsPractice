package Topo;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/5/30
 */
public class Course_4 {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] p : prerequisites) {
//            if (!map.containsKey(p[1])) map.put(p[1], new HashSet<>());
            Set<Integer> its = map.getOrDefault(p[1], new HashSet<>());
            if (map.containsKey(p[0])) {
                Set<Integer> others = map.get(p[0]);
                its.addAll(others);
            }
            its.add(p[0]);

            map.put(p[1], its);
        }
        List<Boolean> list = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            if (map.containsKey(query[1]) && map.get(query[1]).contains(query[0])) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
