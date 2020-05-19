package QiNiu;

import java.util.*;
import java.util.function.Function;

/**
 * @author zhuqiu
 * @date 2020/4/28
 */
public class map {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int node = in.nextInt();
        int line = in.nextInt();
        if (line < node*(node-1) / 2 || node == 0 || line == 0) {
            System.out.println("NO");
            return;
        }
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < line; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == b) {
                continue;
            }
            map.computeIfAbsent(a, integer -> map.put(integer, new HashSet<Integer>()));
            map.computeIfAbsent(b, integer -> map.put(integer, new HashSet<Integer>()));
            map.get(a).add(b);
            map.get(b).add(a);
        }

        map.forEach((key, set) -> {
            for (Integer p : set) {
                map.get(p).addAll(set);
                map.get(p).remove(p);
            }
        });

        if (map.size() < node) {
            System.out.println("NO");
            return;
        }

        for (Map.Entry<Integer, Set<Integer>> integerSetEntry : map.entrySet()) {
            int size = integerSetEntry.getValue().size();
            if (size < node-1) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
//        map.forEach((key, set) -> {
//            if (set.size() < node-1) {
//                System.out.println("NO");
//                return;
//            }
//        });
