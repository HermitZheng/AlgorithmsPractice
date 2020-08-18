package UnionFind;

/**
 * @author zhuqiu
 * @date 2020/6/8
 */
public class FriendCircle {


    public int findCircleNum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        UnionFind unionFind = new UnionFind(grid.length);
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                if (grid[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count();
    }

    private class UnionFind {
        int[] parent;

        public UnionFind(int x) {
            parent = new int[x];
            for (int i = 0; i < x; i++) {
                parent[i] = i;
            }
        }

        public int count() {
//            Set<Integer> set = new HashSet<>();
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) count++;
            }
            return count;
        }

        public void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            if (root_x != root_y) parent[root_x] = root_y;
        }

        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }

    public int findCircleNum_dfs(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    grid[i][j] = 0;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int r, int c) {

        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            if (grid[i][c] == 1) {
                grid[i][c] = 0;
                grid[c][i] = 0;
                dfs(grid, i, c);
            }
        }
        for (int i = 0; i < col; i++) {
            if (grid[r][i] == 1) {
                grid[r][i] = 0;
                grid[i][r] = 0;
                dfs(grid, r, i);
            }
        }
    }
}
