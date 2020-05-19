package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/4
 */
public class StringAdd_1093 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   // 快
        String s1 = in.readLine();
        String s2 = in.readLine();
        int[] list = new int[200];
        char[] s = (s1 + s2).toCharArray();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (list[c] == 0) {
                list[c] = 1;
                System.out.print(c);
            }
        }
    }

    public static void method() {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        char[] s = (s1 + s2).toCharArray();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
