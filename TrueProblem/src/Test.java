
/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(maxCommonDivisor(4, 6));
        System.out.println(minCommonMultiple(4, 6));
    }

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {     // 保证被除数大于除数
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {  // 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;    // 返回最大公约数
    }


    public static int minCommonMultiple(int m, int n) {
        // 最小公倍数
        return m * n / maxCommonDivisor(m, n);
    }
}
