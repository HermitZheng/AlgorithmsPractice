package Bilibili.old;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/13
 */
public class SequenceSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        slideWindow(n);

        /*
        int sum = 0, i = 1;
        int count = 0;
        while (i < n) {
            int begin = i;
            while (sum < n && i < n) {
                sum += i++;
            }
            while (sum > n && begin < i) {
                sum -= begin++;
            }
            if (sum == n) {
                count++;
            }
            sum = 0;
            i = ++begin;
        }
        System.out.println(count+1);
        */
    }

    public static void slideWindow(int n) {
        int sum = 0, left = 1, right = 1, count = 0;
        while (left <= right && right < n) {
            while (sum < n && right < n) {
                sum += right++;
            }
            while (sum > n && left < right) {
                sum -= left++;
            }
            if (sum == n) {
                count++;
            }
            sum -= left++;
        }
        System.out.println(count+1);
    }
}
