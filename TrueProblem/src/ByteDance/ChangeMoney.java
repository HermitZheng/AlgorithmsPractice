package ByteDance;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/8
 */
public class ChangeMoney {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int remain = 1024-in.nextInt();
        int count = 0;
        int coin = 64;
        while (remain >= 4) {
            count += remain/coin;
            remain = remain%coin;
            coin >>= 2;
        }
        count += remain;
        System.out.println(count);
    }
}
