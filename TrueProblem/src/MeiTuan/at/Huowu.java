package MeiTuan.at;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/22
 */
public class Huowu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] weights = new int[n];
        int[] acts = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            acts[i] = in.nextInt();
        }

//        int[][] memo = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            memo[i][i] = weights[i];
//            for (int j = i+1; j < n; j++) {
//                memo[i][j] = memo[i][j-1] + weights[j];
//            }
//        }

        boolean[] set = new boolean[n];

        for (int act : acts) {
            set[act-1] = true;
            int max = 0;
            int i = 0, j = 0;

            while (i < n && j < n) {
                while (i < n && set[i]) {
                    i++;
                }
                if (i == n) {
                    break;
                }
                j = i;

                while (j < n && !set[j]) {
                    j++;
                }
                max = Math.max(max, getWeight(weights, i, j-1));
                i = j;
            }
            System.out.println(max);
        }
    }

    private static int getWeight(int[] list, int i, int j) {
        int sum = 0;
        while (i <= j) {
            sum += list[i++];
        }
        return sum;
    }


}
