package c360;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/22
 */
public class ValidName {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        int count = 0;
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            if (validate(name)) {
                count++;
            }
        }
        System.out.println(count);
    }


    private static boolean validate(String name) {
        if (name.length() > 10) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }
}
