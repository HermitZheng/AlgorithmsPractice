package Didi.at;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/21
 */
public class AaddB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        if (n % 10 % 2 == 1) {
            System.out.println(count);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k <= 9; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    if (calculate(i, j, k) == n) {
                        count++;
                        list.add(100 * i + 10 * j + k);
                        list.add(100 * i + 11 * k);
                    }
                }
            }
        }
        System.out.println(count);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i++) + " " + list.get(i));
        }
    }

    private static int calculate(int a, int b, int c) {
        int num1 = a * 100 + b * 10 + c;
        int num2 = a * 100 + c * 11;
        return num1 + num2;
    }
}
