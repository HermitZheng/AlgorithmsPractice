package Tencent;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/23
 */
public class DividePalindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        char zero = s.charAt(0);
        if (s.charAt(1) == zero) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }
        for (int i = 2; i < s.length(); i++) {
            if (valid(s, 0, i, true)) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int left = in.nextInt();
            int right = in.nextInt();

            System.out.println(dp[right-1]);

        }


    }


    private static boolean valid(String s, int left, int right, boolean flag) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            else if (!flag) {
                return valid(s, left+1, right, true) || valid(s, left, right-1, true);
            } else {
                return false;
            }
        }
        return true;
    }
}
