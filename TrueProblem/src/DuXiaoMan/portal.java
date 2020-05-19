package DuXiaoMan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/20
 */
public class portal {

//    static int count = 0;
    static int A, B, C, N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();
        C = in.nextInt();

        int[] cost = new int[N];    // 从1到N
        for (int i = 0; i < N; i++) {
            cost[i] = in.nextInt();
        }
        int sum = toMax(cost, 0);
        System.out.println(sum);

    }

    public static int toMax(int[] cost, int i) {
        int corrent = cost[i];
        int max = 0, index = 0;
        for (int j = 0; j < cost.length; j++) {
            if (cost[j] > max) {
                max = cost[j];
                index = j;
            }
        }

        if (corrent == max) return 0;

        return 0;
    }
}
