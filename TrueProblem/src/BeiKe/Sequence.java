package BeiKe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/11
 */
public class Sequence {

    static int[] memo;

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   // 快

        int n = Integer.parseInt(in.readLine());
//        int n = in.nextInt();
        String[] s = in.readLine().split(" ");
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(s[i]);
        }
        memo = new int[n];


        int max = 0;
        int distance = list.length;
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                boolean flag = false;

                int sum;
                if (i != j) {
                    sum = method(list, j);
                } else {
                    sum = list[i];
                    memo[i] = sum;
                }

                if (sum > max) {
                    max = sum;
                    distance = j-i+1;
                } else if (sum == max) {
                    if (j-i+1 < distance) {
                        distance = j-i+1;
                    } else {
                        flag = true;
                    }
                } else if (sum < max || flag) {
                    continue;
                }
            }
        }
        System.out.println(distance);

    }

    private static int method(int[] list, int j) {
        memo[j] = memo[j-1] | list[j];
        return memo[j];
    }
}
