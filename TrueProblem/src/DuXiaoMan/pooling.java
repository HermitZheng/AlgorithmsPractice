package DuXiaoMan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/20
 */
public class pooling {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int sum = 0;
        for (int i = 0; i <= n-a; i++) {
            for (int j = 0; j <= m-b; j++) {
                sum += bfs(i, j, n, m, a, b);
            }
        }
        System.out.println(sum);
    }

    public static int bfs(int i, int j, int n, int m, int a, int b) {
        int[][] dirs = {{1, 0}, {0, 1}};
        boolean[][] visited = new boolean[i+a][j+b];
        int max = ((i+1) * (j+1)) % 10;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();    // 上一轮在队列中的元素数量
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                for (int l = 0; l < dirs.length; l++) {
                    int dx = x + dirs[l][0];
                    int dy = y + dirs[l][1];
                    if (dx >= 0 && dx < i+a && dy >= 0 && dy < j+b && visited[dx][dy] == false) {   // 不能越界，且没有被访问过
                        max = Math.max(max, ((dx+1) * (dy+1)) % 10);
                        if (max == 9) return max;
                        queue.add(new int[]{dx, dy});
                        visited[dx][dy] = true;
                    }
                }
            }
        }
        return max;
    }
}
