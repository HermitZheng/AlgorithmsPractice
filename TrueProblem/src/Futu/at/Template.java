package Futu.at;


/**
 * @author zhuqiu
 * @date 2020/8/25
 */
public class Template {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(method(n));
    }

    private static int method(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
