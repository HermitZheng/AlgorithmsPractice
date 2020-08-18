package NetEase.spring;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class DecimalSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] / 9;
            int remain = arr[i] % 9;
            StringBuilder str = new StringBuilder();
            if (remain != 0) {
                str.append(remain);
            }
            for (int j = 0; j < num; j++) {
                str.append(9);
            }
            System.out.println(str);
        }
    }
}
