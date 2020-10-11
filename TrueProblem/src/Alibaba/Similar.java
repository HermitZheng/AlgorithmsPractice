package Alibaba;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/9/1
 */
public class Similar {

    static int count = 0;
    static String t;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        t = in.nextLine();

        range(s);

        System.out.println(count);
    }

    public static boolean similar(String ss, String t) {
        int i = 0, j = 0;
        char[] css = ss.toCharArray();
        char[] ct = t.toCharArray();
        while (i < css.length && j < ct.length && (css.length-i) < (ct.length-j)) {
            if (css[i] == ct[j]) {
                i++;
            }
            j++;
        }
        return i == css.length;
    }

    public static void range(String s) {

        int len = s.length();
        for (int i = 0; i < len; i++) {
            String temp = "";
            for (int j = i; j < (i + s.length()); j++) {
                if (j >= len) {
                    break;
                }
                temp += s.charAt(j);
                if (similar(temp, t)) {
                    count++;
                }
            }
        }

    }
}
