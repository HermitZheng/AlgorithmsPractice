package MeiTuan.spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/23
 */
public class Shopping {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if (res[i] == 1) break;
            for (int j = 0; j < n; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    res[i] = 1;
                    res[j] = 1;
//                    break;
                }
            }
        }
        for (int re : res) {
            System.out.println(re);
        }
    }
}
