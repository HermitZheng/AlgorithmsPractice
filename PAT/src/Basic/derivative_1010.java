package Basic;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/5
 */
public class derivative_1010 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        while (in.hasNext()) {
            int coe = in.nextInt();
            int exp = in.nextInt();
            if (exp != 0) {
                coe *= exp--;
                if (flag) System.out.print(" ");
                if (coe != 0) System.out.print(coe + " " + exp);
                flag = true;
            }
        }
        if (!flag) System.out.print("0 0");
    }
}
