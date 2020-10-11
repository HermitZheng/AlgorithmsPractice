package MeiTuan.at;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/22
 */
public class UserName {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String username = in.nextLine();
            if (verify(username)) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }
        }

    }

    private static boolean verify(String username) {
        if (username.length() <= 1) {
            return false;
        }
        int i = 0;
        char head = username.charAt(i++);
        if (!((head >= 'a' && head <= 'z') || (head >= 'A' && head <= 'Z'))) {
            return false;
        }
        int count = 0;
        while (i < username.length()) {
            char c = username.charAt(i++);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else if (c >= '0' && c <= '9') {
                count++;
            } else {
                return false;
            }
        }
        return count > 0;
    }
}
