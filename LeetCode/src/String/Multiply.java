package String;

/**
 * leetcode 43 multiply, 415 add
 *
 * @author zhuqiu
 * @date 2020/8/13
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i=num1.length()-1, j = num2.length()-1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            if (i >=0) add += num1.charAt(i--) - '0';
            if (j >=0) add += num2.charAt(j--) - '0';
            sb.append(add % 10);
            add /= 10;
        }
        return sb.reverse().toString();
    }
}
