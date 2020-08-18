package NetEase.spring;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class Subsequence {

    static int max = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            max = 0;
            int sum = 0;
            int num;
            int len = 0;
            int count = in.nextInt();
            for (int j = 0; j < count; j++) {
                if ((num = in.nextInt()) >= sum) {
                    sum += num;
                    len++;
                    continue;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                    sum = num;
                }
            }
            System.out.println(max);
        }
    }


}
