package AnHeng;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/9/13
 */
public class Travel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < input.length - 1; i++) {
            prices.add(Integer.valueOf(input[i]));
        }
        int target = Integer.parseInt(input[input.length-1]);

        int[] dp = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        Collections.sort(prices);

        for (Integer price : prices) {
            if (price > target) continue;
            dp[price] = 1;
            for (int i = price+1; i <= target; i++) {
                dp[i] = Math.min(dp[i], dp[i-price] + dp[price]);
            }
        }
        if (dp[target] == Integer.MAX_VALUE / 2) {
            System.out.println(-1);
        } else {
            System.out.println(dp[target]);
        }
    }
}
