package Advanced;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/27
 */
public class AplusB_1001 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        StringBuilder sb = new StringBuilder();
        int sum = a + b;
        if (sum == 0) {
            System.out.println("0");
            return;
        }
        boolean flag = false;
        if (sum < 0) {
            flag = true;
            sum = -sum;
        }
        int count = 0;
        while (sum > 0) {
            sb.insert(0, sum % 10);
            sum /= 10;
            if (++count % 3 == 0 && sum != 0) sb.insert(0, ",");
        }
        if (flag) sb.insert(0, "-");
        System.out.println(sb);
    }
}
