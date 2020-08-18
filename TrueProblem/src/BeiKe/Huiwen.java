package BeiKe;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/11
 */
public class Huiwen {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = Integer.parseInt(in.nextLine());

        String s = in.nextLine();
        String[] split = s.split("");
        int left = 0, right = len-1;
        int count = 0;
        while (left < right) {
            if (!split[left].equals(split[right])) {
                count++;
            }
            left++;
            right--;
        }
        System.out.println(count);
    }
}
