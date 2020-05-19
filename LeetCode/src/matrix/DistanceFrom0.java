package matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuqiu
 * @date 2020/4/15
 */
public class DistanceFrom0 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] ints = new DistanceFrom0().bfs(matrix);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.printf("%d ", ints[i][j]);
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = Integer.MAX_VALUE / 2;  // 由于是取min，将所有不为0的位置都设为大数字
                }
            }
        }

        for (int i = 0; i < row; i++) {         // 从左上到右下遍历
            for (int j = 0; j < col; j++) {
                if (i - 1 >= 0) {
                    visited[i][j] = Math.min(visited[i][j], visited[i - 1][j] + 1);     // 状态转移
                }
                if (j - 1 >= 0) {
                    visited[i][j] = Math.min(visited[i][j], visited[i][j - 1] + 1);
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {    // 从右下到左上遍历
            for (int j = col - 1; j >= 0; j--) {
                if (i + 1 < matrix.length) {
                    visited[i][j] = Math.min(visited[i][j], visited[i + 1][j] + 1);
                }
                if (j + 1 < matrix[0].length) {
                    visited[i][j] = Math.min(visited[i][j], visited[i][j + 1] + 1);
                }
            }
        }
        return visited;
    }

    public int[][] bfs(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] visited = new boolean[row][col];
        int[][] res = new int[row][col];            // 默认全为0
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {            // 对matrix = 0的位置入队，从这些点出发开始搜索
                    visited[i][j] = true;           // 设为已访问
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // 四个方向
        while (!queue.isEmpty()) {
            int size = queue.size();    // 上一轮在队列中的元素数量
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                for (int j = 0; j < dirs.length; j++) {
                    int dx = x + dirs[j][0];
                    int dy = y + dirs[j][1];
                    if (dx >= 0 && dx < row && dy >= 0 && dy < col && visited[dx][dy] == false) {   // 不能越界，且没有被访问过
                        res[dx][dy] = res[x][y] + 1;
                        queue.add(new int[]{dx, dy});
                        visited[dx][dy] = true;
                    }
                }
            }
        }
        return res;
    }

}
