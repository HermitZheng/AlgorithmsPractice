package Basic;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/4
 */
public class printNum_1006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while (num >= 100) {
            sb.append("B");
            num -= 100;
        }
        while (num >= 10) {
            sb.append("S");
            num -= 10;
        }
        for (int i = 1; i <= num; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
