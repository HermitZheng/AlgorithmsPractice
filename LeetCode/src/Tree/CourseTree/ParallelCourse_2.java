package Tree.CourseTree;

import java.util.*;

/**
 * leetcode 5435. 并行课程 II
 *
 * @author zhuqiu
 * @date 2020/6/27
 */
public class ParallelCourse_2 {

    public static void main(String[] args) {
        int[][] dependencies = {{1, 5}, {1, 3}, {1, 2}, {4, 2}, {4, 5}, {2, 5}, {1, 4}, {4, 3}, {3, 5}, {3, 2}};
//        int[][] dependencies = {{2, 1}, {2, 4}};
//        int[][] dependencies = {{4, 5}, {2, 1}, {2, 4}, {2, 5}, {5, 3}, {1, 4}, {1, 3}, {2, 3}, {1, 5}};
        int i = new ParallelCourse_2().minNumberOfSemesters(5, dependencies, 3);
        System.out.println(i);
    }

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {   // 3 4 6 5 2 5
        int term = 0, i = 0;
//        List<Integer[]> list = new ArrayList<>();
//        for (int[] dependency : dependencies) {
//            list.add(new Integer[] {dependency[0], dependency[1]});
//        }
//        Collections.sort(list, Comparator.comparingInt(o -> o[1]));
//        for (int j = 0; j < dependencies.length; j++) {
//            Integer[] pair = list.get(i);
//            dependencies[j] = new int[] {pair[0], pair[1]};
//        }
        Set<Integer> courses = new HashSet<>();
        Set<Integer> already = new HashSet<>();
        outer:
        while (n > 0) {
            if (i == dependencies.length) {
                return term + (n % k == 0 ? n/k:n/k+1);
            }
            Set<Integer> set = new HashSet<>();
            Set<Integer> alreadyTemp = new HashSet<>();
            term++;
            int num = 0;
            while (i < dependencies.length && num < k) {
                if (already.contains(dependencies[i][0])) {
                    i++;
                    continue;
                }
                if (alreadyTemp.contains(dependencies[i][0])) {
                    set.add(dependencies[i][1]);
                    i++;
                    continue;
                }
                if (set.contains(dependencies[i][0])) continue outer;
                set.add(dependencies[i][1]);
                alreadyTemp.add(dependencies[i][0]);
                num++;
                if (!courses.contains(dependencies[i][0])) {
                    n--;
                }
                courses.add(dependencies[i][0]);
                i++;
            }
            while (n > set.size() && num < k) {
                n--;
                num++;
            }
            already.addAll(alreadyTemp);
        }

        return term;
    }
}
