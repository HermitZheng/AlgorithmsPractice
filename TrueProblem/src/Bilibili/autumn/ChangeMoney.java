package Bilibili.autumn;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/13
 */
public class ChangeMoney {

    public int GetCoinCount(int N) {
        int remain = 1024-N;
        int count = 0;
        int coin = 64;
        while (remain >= 4) {
            count += remain/coin;
            remain = remain%coin;
            coin >>= 2;
        }
        count += remain;
        return count;
    }
}
