package Basic;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/5
 */
public class minNum_1023 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] list = new int[10];
        for (int i = 0; i < 10; i++) {
            list[i] = in.nextInt();
        }
        for (int i = 1; i < 10; i++) {
            if (list[i] != 0) {
                System.out.print(i);
                list[i]--;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            while (list[i] != 0) {
                System.out.print(i);
                list[i]--;
            }
        }
    }
}
