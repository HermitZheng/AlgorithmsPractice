package Array;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/8/23
 */
public class MaxCoins {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0, count = 0;
        int len = piles.length;
        for (int i = len-2; i >= 0 && count < len / 3; i-=2) {
            sum += piles[i];
            count++;
        }
        return sum;
    }
}
