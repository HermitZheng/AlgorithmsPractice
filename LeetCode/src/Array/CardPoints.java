package Array;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/4/26
 */
public class CardPoints {

    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int i = new CardPoints().maxScore(cardPoints, 3);
        System.out.println(i);
    }

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        if (len == k) {
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += cardPoints[i];
            }
            return sum;
        }
        int[] dp = new int[k + 1];
        int i = 0, j = len - k, rightSum = 0;
        for (int l = j; l < len; l++) {
            rightSum += cardPoints[l];
        }
        dp[0] = rightSum;
        for (i = 1; i <= k; i++) {
            dp[i] = dp[i-1] - cardPoints[j++] + cardPoints[i-1];
        }

        int max = 0;
        for (int l = 0; l <= k; l++) {
            max = Math.max(max, dp[l]);
        }
        return max;
    }
}
