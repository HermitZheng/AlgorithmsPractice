package DuXiaoMan;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/9/20
 */
public class Escape {

    static int res = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            res = Integer.MAX_VALUE / 2;
            int rows = in.nextInt(), cols = in.nextInt();
            in.nextLine();
            char[][] matrix = new char[rows][cols];
            int[] begin = new int[2];
            for (int j = 0; j < rows; j++) {
                int k = 0;
                for (char c : in.nextLine().toCharArray()) {
                    matrix[j][k++] = c;
                    if (c == '@') {
                        begin[0] = j;
                        begin[1] = k-1;
                    }
                }
            }
            boolean[][] used = new boolean[rows][cols];
            dfs(matrix, begin[0], begin[1], used, 0);
            System.out.println(res>=Integer.MAX_VALUE/2-1 ? -1 : res);
        }
    }

    private static void dfs(char[][] matrix, int i, int j, boolean[][] used, int sum) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            res = Math.min(res, sum);
            return;
        }
        if (used[i][j] || matrix[i][j] == '#') {
            return;
        }

        if (matrix[i][j] == '*') {
            sum++;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        used[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(matrix, x, y, used, sum);
        }

        used[i][j] = false;

        if (matrix[i][j] == '*') {
            sum--;
        }
    }
}
