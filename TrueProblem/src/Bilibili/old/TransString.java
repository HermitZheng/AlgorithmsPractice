package Bilibili.old;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/13
 */
public class TransString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int len1 = a.length(), len2 = b.length();

        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = dp[i-1][j] + 1;
                    int del = dp[i][j-1] + 1;
                    int upd = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(Math.min(add, del), upd);
                }
            }
        }
        System.out.println(dp[len1][len2]);
    }
}
