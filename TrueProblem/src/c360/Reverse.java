package c360;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/8/24
 */
public class Reverse {

    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) {

        char[] list = {'A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y'};
        for (char c : list) {
            set.add(c);
        }

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();
            if (verify(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean verify(String s) {
        int left = 0, right = s.length()-1;
        char[] chars = s.toCharArray();

        while (left < right) {
            if (!set.contains(chars[left]) || chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        if (left == right && !set.contains(chars[left])) {
            return false;
        }
        return true;
    }
}
