package ByteDance;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/8
 */
public class EngCheck {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(in.nextLine());
            for (int j = 2; j < sb.length(); j++) {
                if (sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j - 1) == sb.charAt(j - 2)) {
                    sb.deleteCharAt(j);
                    j--;
                } else if (isPattern(sb, j - 3, j)) {
                    sb.deleteCharAt(j);
                    j--;
                }
            }
            System.out.println(sb);
        }

    }

    public static boolean isPattern(StringBuilder sb, int i, int j) {
        if (i < 0) return false;
        return sb.charAt(i) == sb.charAt(i + 1) &&
                sb.charAt(j - 1) == sb.charAt(j);
    }
}
