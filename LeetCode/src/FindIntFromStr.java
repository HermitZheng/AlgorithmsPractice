import sun.applet.Main;

import java.util.regex.Pattern;

/**
 * @author zhuqiu
 * @date 2020/4/10
 */
public class FindIntFromStr {
    public static void main(String[] args) {
        String str = "+";
        int result = new FindIntFromStr().strToInt(str);
        System.out.println(result);
        System.out.println(!"-".equals("-"));
    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String[] split = str.trim().split("");
        StringBuilder stringBuilder = new StringBuilder();
        String sign = split[0];
        if (!Pattern.matches("[0-9]", sign) && (!sign.equals("+") && !sign.equals("-"))) {
            return 0;
        }
        int i = 1;
        while (i < split.length && !Pattern.matches("[a-z+-]\\s", split[i])) {
            stringBuilder.append(split[i]);
            i++;
        }
        if (stringBuilder.length() > 0 || Pattern.matches("[0-9]", sign)) {
            stringBuilder.insert(0, sign);
        }
        if (stringBuilder.length() == 0){
            return 0;
        }
        double result = Double.parseDouble(String.valueOf(stringBuilder));
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
