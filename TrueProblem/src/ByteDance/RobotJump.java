package ByteDance;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/8
 */
public class RobotJump {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        double energy = 0;
        for (int i = arr.length-1; i >=0 ; i--) {
            energy = Math.ceil((energy+arr[i])/2.0);    // 设下一级的高度为H，则跳跃到下一级之后的能量为2E-H
                                                        // 由此，把这一级的能量看作E'=(2E-H)，显然E'+H = 2E
                                                        // 因为E'实际上就是E，所以上一级时的能量为E=(E'-H)/2.0
                                                        // 由于要确保能量够用，所以每一次都要向上取整ceil
        }
        System.out.println((int)energy);
    }
}
