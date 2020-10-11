package SouGou;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/9/5
 */
public class Award {

    public static void main(String[] args) {
//        int[] list = {4,4,2};
//        int[] list = {9,3,3};
        int[] list = {8,0,0};
        int res = new Award().numberofprize(list[0], list[1], list[2]);

        System.out.println(res);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能交换奖品的最大数量
     *
     * @param a int整型
     * @param b int整型
     * @param c int整型
     * @return int整型
     */
    public int numberofprize(int a, int b, int c) {
        // write code here
        int count = Math.min(a, Math.min(b, c));
        a -= count;
        b -= count;
        c -= count;

        int[] list = {a, b, c};
        Arrays.sort(list);
        if (list[2] == 0) {
            return count;
        }

        int n = list[2] / 3;

        if (n >= list[1]) {
            list[2] -= 3 * list[1];
            count += list[1];
            return count + list[2] / 5;
        } else {
            list[2] -= 3 * n;
            list[1] -= n;
            count += n;
            return count + (list[1] + list[2]) / 4;
        }

//        while (list[1] != 0) {
//            if (list[2] <= 3) {
//                return (int)(count + (list[1] + list[2]) / 4);
//            }
//            long n = list[2] / 3;
//
//            if (n >= list[1]) {
//                list[2] -= 3 * list[1];
//                count += list[1];
//                list[1] = 0;
//            } else {
//                list[2] -= 3 * n;
//                list[1] -= n;
//                count += n;
//            }
////            count++;
//
//            Arrays.sort(list);
//        }
//
//        if (list[2] >= 5) {
//            count += list[2]/5;
//        }
//
//        return (int)count;
    }
}
