package Array;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/4/26
 */
public class Split {

    public static void main(String[] args) {
        String s = "011101";
        int i = new Split().maxScore(s);
        System.out.println(i);
    }

    public int maxScore(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] split = s.split("");
        int len = s.length();
        int[] dp = new int[len-1];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (split[i].equals("1")) {
                count++;
            }
        }
        Arrays.fill(dp, count);
        if (split[0].equals("0")) dp[0] = count + 1;
        else dp[0] = count - 1 ;
        for (int i = 1; i < len-1; i++) {
            if (split[i].equals("0")) {
                dp[i] = dp[i-1] + 1;
            } else if (split[i].equals("1")) {
                dp[i] = dp[i-1] - 1;
            }
        }
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
