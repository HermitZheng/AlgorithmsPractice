package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuqiu
 * @date 2020/4/20
 */
public class IslandNums {

    public static void main(String[] args) {
        String[][] grid = {{"1","1","1","1","0"},
                           {"1","1","0","1","0"},
                           {"1","1","0","0","0"},
                           {"0","0","0","0","0"}};
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                }
            }
        }

        return count;

    }

    public void dfs(char[][] grid, int r, int c) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < dirs.length; i++) {
            int dr = r + dirs[i][0], dc = c + dirs[i][1];
            if (dr >= 0 && dr < row && dc >= 0 && dc < col && grid[dr][dc] != '0') {
                grid[dr][dc] = '0';
                dfs(grid, dr, dc);
            }
        }
    }

    public int numsBFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {

                }
            }
        }

        return 0;
    }
}
