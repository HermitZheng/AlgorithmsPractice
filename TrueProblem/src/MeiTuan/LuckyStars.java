package MeiTuan;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/23
 */
public class LuckyStars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] pos = new int[n][2];
        Queue<int[]> queue = new LinkedList<>();
//        HashSet<int[]> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            min = Math.min(min, Math.min(x, y));
            max = Math.max(max, Math.max(x, y));
            queue.offer(new int[]{x, y});
//            set.add(pos[i]);
        }
        int[][] mat = new int[min][max];

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                boolean flag = true;
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int j = 0; j < dirs.length; j++) {
                    int dx = x + dirs[j][0];
                    int dy = y + dirs[j][1];

                }
                if (flag == true) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
