package MeiTuan;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/23
 */
public class Money {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String money = in.nextLine();
            System.out.println(deal(money));
        }
    }

    public static String deal(String money) {
        StringBuilder sb = new StringBuilder();
        int flag = 0, little = 0, dot = 0;
        int len = money.length();
        int i = 0;
        if (money.charAt(0) == '-') {
            flag = 1;
            i++;
        }
        int pre = 0;
        outer:
        while (i < len) {
            for (int j = 0; j < 3; j++) {
                char c = money.charAt(i);
                if (c == '.') {
                    pre = sb.length();
                    dot = 1;
                    i++;
                    sb.append('.');
                    for (int k = 0; k < 2; k++) {
                        if (i < len) sb.append(money.charAt(i++));
                        else sb.append('0');
                    }
                    break outer;
                }
                sb.append(money.charAt(i++));
            }
            if (i < len - 1 && money.charAt(i) != '.') {
                little++;
            }
        }
        len = sb.length();
        int mod = pre % 3;
        while (little > 0) {
            if (mod == 0) mod = 3;
            sb.insert(mod, ',');
            mod += 4;
            little--;
        }
        if (dot == 0) {
            sb.append(".00");
        }
        sb.insert(0, '$');
        if (flag == 1) {
            sb.insert(0, '(');
            sb.append(')');
        }

        return sb.toString();
    }
}
