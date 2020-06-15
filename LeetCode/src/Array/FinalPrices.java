package Array;


/**
 * @author zhuqiu
 * @date 2020/6/13
 */
public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        if (len == 0) return new int[]{};
        int[] res = new int[len];

        outer:
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] = prices[i]-prices[j];
                    continue outer;
                }
            }
            res[i] = prices[i];
        }
        return res;
    }
}
