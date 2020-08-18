package Bilibili.old;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/3/16
 */
public class Knapsack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = Integer.parseInt(in.nextLine());
        int sumWeight = Integer.parseInt(in.nextLine());

        String weightList = in.nextLine();

        int[] weight = new int[num];
        String[] s1 = weightList.split(" ");
        if (s1 != null){
            for (int i = 0; i < s1.length; i++) {
                weight[i] = Integer.parseInt(s1[i]);
            }
        }

        String valueList = in.nextLine();

        int[] value = new int[num];
        String[] s2 = valueList.split(" ");
        if (s2 != null){
            for (int i = 0; i < s2.length; i++) {
                value[i] = Integer.parseInt(s2[i]);
            }
        }
        in.close();

        int max = traceBack(num, sumWeight, weight, value);
        System.out.println(max);
    }

    public static int traceBack(int num, int sumWeight, int[] weight, int[] value) {
        int[] dp = new int[sumWeight+1];         // 对背包重量内所有可能的重量，建立对应的价值表

        for (int i = 0; i < num; i++) {           // 尝试将所有物品放入背包中
            for (int j = sumWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j - weight[i]] + value[i]    // 在放入当前物品 i 之前背包的最大价值，加上物品 i 的价值
                                , dp[j]);                        // 同不放入物品 i 的最大价值进行比较
            }
        }
        return dp[sumWeight];
    }
}
