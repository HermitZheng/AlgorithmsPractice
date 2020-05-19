package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author zhuqiu
 * @date 2020/4/8
 */
public class RobotMove {

    public int movingDFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return this.dfs(0, 0, m, n, k, visited);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || visited[i][j] || i % 10 + i / 10 + j % 10 + j / 10 > k) {  // 注意：这里坐标的计算要求m和n小于等于99，100以上会失效
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);  // +1相当于在计数
    }

    public int movingBFS(int m, int n, int k) {
        if (k < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 0}, dy = {0, 1};
        int res = 1;
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            for (int i = 0; i < 2; i++) {
                int nextx = x + dx[i], nexty = y + dy[i];

                if (nextx < m && nexty < n && !visited[nextx][nexty] &&
                        nextx % 10 + nextx / 10 + nexty % 10 + nexty / 10 <= k) {
                    res++;
                    visited[nextx][nexty] = true;
                    queue.offer(new int[]{nextx, nexty});
                }
            }
        }
        return res;
    }

}
