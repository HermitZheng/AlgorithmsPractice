package Design;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuqiu
 * @date 2020/5/31
 */
public class ReplanRoute {

    public int minReorder(int n, int[][] connections) {
        Set<Integer> set = new HashSet<>(n);
        set.add(0);
        int count = 0;
        for (int[] connection : connections) {
            if (set.contains(connection[0])) count++;
            set.add(connection[0]);
            set.add(connection[1]);
        }
        return count;
    }
}
