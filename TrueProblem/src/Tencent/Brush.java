package Tencent;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/23
 */
public class Brush {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = in.nextInt();
        }

        System.out.println(n);
    }
}
