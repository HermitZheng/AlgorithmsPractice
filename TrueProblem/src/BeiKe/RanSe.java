package BeiKe;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/11
 */
public class RanSe {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int rows = in.nextInt();
            int cols = in.nextInt();
            System.out.println(Math.min(method(rows), method(cols)));
        }
    }

    public static int method(int n) {
        outer:
        for (int i = n; i >= 2; i--) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            return i;
        }
        return n;
    }


}
