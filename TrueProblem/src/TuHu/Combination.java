package TuHu;

/**
 * 阶乘
 *
 * @author zhuqiu
 * @date 2020/9/10
 */
public class Combination {

    public static void main(String[] args) {
        int r = 2, n = 3;
        int combination = new Combination().combination(r, n);

        System.out.println(combination);
    }

    public int combination(int r, int n) {
        // write code here
        if (r == 0) {
            return 1;
        }
        if (r == 1) {
            return n;
        }
        if (r > n / 2) {
            return combination(n - r, n);
        }
        return combination(r, n-1) + combination(r-1, n-1);
    }

    public int combination__(int r, int n) {
        // write code here
        if (r == 0) {
            return 1;
        }
        if (r == 1) {
            return n;
        }
        if (r > n / 2) {
            return combination(n - r, n);
        }
        int min = Math.min(r, Math.min(n - r, n));
        long min_sum = cal(min, 1, 1);

        int mid = Math.max(r, Math.min(n - r, n));
        long mid_sum = cal(mid, min, min_sum);

        int max = Math.max(r, Math.max(n - r, n));
        long max_sum = cal(max, mid, mid_sum);

        return (int) (max_sum / mid_sum / min_sum);
    }

    public long cal(int end, int begin, long beginSum) {
        long sum = beginSum;
        for (int i = begin + 1; i <= end; i++) {
            sum *= i;
        }
        return sum;
    }
}
