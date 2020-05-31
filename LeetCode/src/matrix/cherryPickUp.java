package matrix;


/**
 * leetcode 5411
 *
 * @author zhuqiu
 * @date 2020/5/30
 */
public class cherryPickUp {

    public static void main(String[] args) {
        int[][] grid = {{3, 1, 1},
                        {2, 5, 1},
                        {1, 5, 5},
                        {2, 1, 1}};
        int res = new cherryPickUp().cherryPickup(grid);
        System.out.println(res);
    }

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        return dfs(grid, 0, 0, visited) + dfs(grid, 0, cols-1, visited);
    }

    private synchronized int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        // dfs出口，不满足条件就退出
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return 0;
        // 操作
        int get = grid[i][j];
        grid[i][j] = 0;
        // 递归，接着进一步DFS
        int temp = 0;
        int max1 = dfs(grid, i+1, j-1, visited);
        int max2 = dfs(grid, i+1, j, visited);
        int max3 = dfs(grid, i+1, j+1, visited);
        if (max1 >= max2 && max1 >= max3 && j-1 >= 0) {
            visited[i][j-1] = true;
            return max1;
        } else if (max2 >= max1 && max2 >= max3) {
            visited[i][j] = true;
            return max2;
        } else if (j+1 < n){
            visited[i][j+1] = true;
            return max3;
        }
        return 0;
    }
}
