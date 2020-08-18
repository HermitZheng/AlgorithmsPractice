package matrix;

/**
 * @author zhuqiu
 * @date 2020/8/11
 */
public class SurroundedArea {

    public static void main(String[] args) {
        char[][] board = {{'O','X','X','O','X'}
                         ,{'X','O','O','X','O'}
                         ,{'X','O','X','O','X'}
                         ,{'O','X','O','O','O'}
                         ,{'X','X','O','X','O'}};
        new SurroundedArea().solve(board);
    }

    boolean[][] visited;
    int rows, cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, i, 0, true);
            }
            if (board[i][cols - 1] == 'O' && !visited[i][cols - 1]) {
                dfs(board, i, cols - 1, true);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, 0, j, true);
            }
            if (board[rows - 1][j] == 'O' && !visited[rows - 1][j]) {
                dfs(board, rows - 1, j, true);
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, false);
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, boolean edge) {

        visited[x][y] = true;
        if (!edge) {
            System.out.println("冲：" + x + " " + y);
            board[x][y] = 'X';
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (newx >= 0 && newx < rows && newy >= 0 && newy < cols && !visited[newx][newy] && board[newx][newy] == 'O') {
                dfs(board, newx, newy, edge);
            }
        }
    }
}
