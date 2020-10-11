package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/8/23
 */
public class Circular {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int begin = rounds[0];
        int count = 0;
        for (int i = 1; i < rounds.length; i++) {
            int next = rounds[i];
            if (next > begin) {
                continue;
            } else {
                count++;
            }
        }
        int end = rounds[rounds.length-1];
        List<Integer> res = new ArrayList<>();
        if (end > begin) {


            while (begin <= end) {
                res.add(begin++);
            }
            return res;
        }
        if (end == begin) {
            res.add(begin);
            return res;
        }
        else {
            for (int i = 1; i <= end; i++) {
                res.add(i);
            }
            for (int i = begin; i <= n; i++) {
                res.add(i);
            }
            return res;
        }
    }
}
