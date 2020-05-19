package Substring;

/**
 * @author zhuqiu
 * @date 2020/4/13
 */
public class LongestCommonSub {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int result = new LongestCommonSub().longestCommonSubsequence(s1, s2);
        System.out.println(result);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        String[] str1 = text1.split("");
        String[] str2 = text2.split("");

        int result = dp(str1, str2);
        return result;
    }

    public int dp(String[] text1, String[] text2) {
        int len1 = text1.length;
        int len2 = text2.length;
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1[i-1].equals(text2[j-1])) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[len1][len2];
    }
}
