package ByteDance;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/8
 */
public class Ambush {

    static long count = 0;
    static int len;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        len = n;
//        int i = 0;
//        while (i < len - 2 && find(arr, i, d)) {
//            i++;
//        }
        calculate(arr, 0, 2, d);
        if (count >= 99997867){
            count = count%99997867;
        }
        System.out.println(count);
    }

    public static void calculate(int[] arr, int left, int right, int d) {
        if (right >= len && arr[left + 1] - arr[left] > d) {
            return;
        }
        while (right < len) {
            if (arr[right] - arr[left] > d) {
                left++;
            } else if (right - left < 2){
                right++;
            } else {
                count += nums(right-left);
                right++;
            }
            if (count >= 99997867){
                count = count%99997867;
            }
        }
    }

    public static long nums(long n) {
        return n*(n-1)/2;
    }

    public static boolean find(int[] arr, int i, int d) {
        int j = i+2;
        if (j >= len && arr[i + 1] - arr[i] > d) {
            return false;
        } else {
            int k = 2;
            while (i + k < len && arr[i + k] - arr[i] <= d) {
                count += k-1;
                k++;
            }
            if (count > 99997867){
                count = count%99997867;
            }
            return true;
        }
    }
}
