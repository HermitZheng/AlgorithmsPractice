package Tencent;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/23
 */
public class MaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            long n = in .nextLong();
            long res = calculate(n);
            System.out.println(res);
        }
    }

    private static long calculate(long num) {
        if (num <= 10) {
            return num;
        }
        long key = 9;
        long add = 0;

        while (num > key) {
            add += key;
            num -= key;
            key *= 10;
        }

        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        while (add > 0) {
            res += add % 10;
            add /= 10;
        }
        return res;
    }
}
