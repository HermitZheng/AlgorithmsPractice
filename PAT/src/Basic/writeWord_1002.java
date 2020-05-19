package Basic;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/4
 */
public class writeWord_1002 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int sum = 0;
        char[] chars = s.toCharArray();
        for (char a : chars) {
            sum += a - '0';
        }
        chars = (sum + "").toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (flag) System.out.print(" ");
            sout(chars[i]);
            flag = true;
        }
    }

    public static void sout(char c) {
        switch (c) {
            case '1' :
                System.out.print("yi");
                break;

            case '2' :
                System.out.print("er");
                break;

            case '3' :
                System.out.print("san");
                break;

            case '4' :
                System.out.print("si");
                break;

            case '5' :
                System.out.print("wu");
                break;

            case '6' :
                System.out.print("liu");
                break;

            case '7' :
                System.out.print("qi");
                break;

            case '8' :
                System.out.print("ba");
                break;

            case '9' :
                System.out.print("jiu");
                break;

            case '0':
                System.out.println("ling");
                break;
        }
    }
}
