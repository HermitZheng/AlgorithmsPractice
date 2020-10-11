package XiaoMi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/9/8
 */
public class Demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String ss = in.nextLine();
        String[] list = ss.split(" ");
        boolean[] type = new boolean[4];

        for (String s : list) {
            int len = s.length();
            if (len < 8 || len > 120) {
                System.out.println(1);
                continue;
            }
            Arrays.fill(type, false);

            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    type[0] = true;
                } else if (c >= 'a' && c <= 'z') {
                    type[1] = true;
                } else if (c >= 'A' && c <= 'Z') {
                    type[2] = true;
                } else {
                    type[3] = true;
                }
            }
            if (type[0] && type[1] && type[2] && type[3]) {
                System.out.println(0);
            } else {
                System.out.println(2);
            }
        }
    }
}
