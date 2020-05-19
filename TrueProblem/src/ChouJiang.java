import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/3/24
 */
public class ChouJiang {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int yes = in.nextInt();
        int no = in.nextInt();
        double p = method(yes, no);
        double result = (yes + no + 1)/10.0000;
        System.out.println(result);
    }

    public static double method(int yes, int no) {
        double result = 1;
        int sum = yes + no;
        double Awin = yes / (sum * 1.000);
        while (sum > 0 && yes > 0) {
            if (sum <= 3) {
                double p = yes / (sum * 1.000);
                result *= p;
                break;
            }
            Awin += yes / (sum * 1.000);
            double p = no / (sum * 1.000);
            result *= p;
            no--;


            result += Awin;
            return result;
        }
        return result;
    }
}
