package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/4
 */
public class rightMove_1008 {

    public static void main(String[] args) {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = in.readLine().split(" ");
//        int N = Integer.parseInt(s[0]);
//        int M = Integer.parseInt(s[1]);
//        int[] list = new int[N];
//        s = in.readLine().split(" ");
//        for (int i = 0; i < N; i++) {
//            list[i] = Integer.parseInt(s[i]);
//        }
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = in.nextInt();
        }
        boolean flag = false;
        for (int i = N - (M % N); i < N; i++) {
            if (flag) System.out.print(" ");
            System.out.print(list[i]);
            flag = true;
        }
        for (int i = 0; i < N - (M % N); i++) {
            if (flag) System.out.print(" ");
            System.out.print(list[i]);
            flag = true;
        }
    }
}
