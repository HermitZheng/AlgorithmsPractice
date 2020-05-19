package Basic;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/4
 */
public class primePair_1007 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pre = 2, count = 0;
        for (int i = 3; i <= n; i++) {
            boolean flag = false;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (i-pre == 2) {
                    count++;
                }
                pre = i;
            }
        }
        System.out.println(count);
    }
}
