package Search;

/**
 * leetcode 69
 *
 * @author zhuqiu
 * @date 2020/5/9
 */
public class Sqrt {

    public static void main(String[] args) {
        int i = new Sqrt().mySqrt(9);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;

        int left = 0, right = x / 2 + 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid*mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
