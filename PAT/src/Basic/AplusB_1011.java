package Basic;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/5
 */
public class AplusB_1011 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            long a = in.nextInt();
            long b = in.nextInt();
            long c = in.nextInt();
            if (a + b > c) System.out.printf("Case #%d: true", i);
            else System.out.printf("Case #%d: false", i);
            System.out.println();
        }
    }
}
