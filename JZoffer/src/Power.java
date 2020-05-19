/**
 * @author zhuqiu
 * @date 2020/3/10
 */

/**
 *  首先要考虑次数和乘子是否为零
 *  其次是乘子和次数分别为零的情况
 */
public class Power {

    public double Power(double base, int exponent) {
        Double result = base;
        if (base == 0){
            return 0;
        } else if (exponent == 0){
            return 1;
        }else if (exponent > 0){
            for (int i = 0; i < exponent-1; i++) {
                result *= base;
            }
        } else if (exponent < 0){
            for (int i = 0; i < -exponent-1; i++) {    // 此处应该先把次数化为正
                result *= base;
            }
            result = 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        Power power = new Power();
        double result = power.Power(2, -3);
        System.out.println(result);
    }
}
