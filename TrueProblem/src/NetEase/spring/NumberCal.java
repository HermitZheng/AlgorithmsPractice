package NetEase.spring;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class NumberCal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = 0;
            long a = in.nextInt();
            long b = in.nextInt();
            long p = in.nextInt();
            long q = in.nextInt();
            while (a+p < b) {
                p *= q;
                num ++;
            }
            System.out.println(num + 1);
        }
    }
}
