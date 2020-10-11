import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class Test {
    public static void main(String[] args) {
        int[][] a = {{5, 85, 4, 2, 68},
                {78, 82, 75, 41, 14},
                {79, 47, 38, 1, 47},
                {1, 2, 14, 65, 13},
                {96, 87, 32, 14, 21}};
        int[][] b = maxCommonDivisor(a);

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] maxCommonDivisor(int[][] a) {
        int[][] b = new int[a.length][a[0].length];

        int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {1, -1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (x >= 0 && x < a.length && y >= 0 && y < a[0].length) {
                        list.add(a[x][y]);
                    }
                }
                Collections.sort(list);
                b[i][j] = list.get(list.size() / 2);
            }
        }
        return b;
    }
}
