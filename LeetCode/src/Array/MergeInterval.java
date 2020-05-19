package Array;

import javax.management.RuntimeErrorException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zhuqiu
 * @date 2020/4/16
 */
public class MergeInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1,3},
//                            {2,6},
//                            {8,10},
//                            {15,18}};
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] merge = new MergeInterval().merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[0].length; j++) {
                System.out.printf("%d ", merge[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][]{};
        }
        int len1 = intervals.length, len2 = intervals[0].length;
        ArrayList<int[]> res = new ArrayList<>(len1);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int pre = 0, p = 0;
        int max_x = intervals[0][0], max_y = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0], y = intervals[i][1];
            if (x > max_y) {
//                res[p++] = new int[] {intervals[pre][0], max_y};
                res.add(new int[] {intervals[pre][0], max_y});
                pre = i;
                max_y = y;
            } else {
                max_y = Math.max(max_y, y);
            }
        }
//        res[p++] = new int[] {intervals[pre][0], max_y};
        res.add(new int[] {intervals[pre][0], max_y});

        return res.toArray(new int[res.size()][2]);
    }
}
