package Alibaba;

import java.util.Random;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/9/1
 */
public class Message {

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        Random random = new Random();
        int[] list = {0, 2, 3};
        System.out.println(list[random.nextInt(3)]);
    }
}

