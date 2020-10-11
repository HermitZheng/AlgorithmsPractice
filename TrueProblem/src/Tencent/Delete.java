package Tencent;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/23
 */
public class Delete {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (i != k) {
                sb.append(num + " ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
