package String;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/3/24
 */
public class Coding {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String result = coding(string);
        System.out.println(result);
    }


    public static String coding(String string) {
        if (string == null){
            return null;
        }
        String c = new String();
        String result = new String();
        int num = 0;
        for (int i = 0; i < string.length(); i++) {
            if (!c.equals(string.substring(i, i+1))) {
                if (!c.equals("")){
                    result += num + c;
                }
                c = string.substring(i, i+1);
                num = 0;
            }
            num++;
        }
        result += num + c;
        return result;
    }
}
