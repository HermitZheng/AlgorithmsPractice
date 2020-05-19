package MeiTuan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/23
 */
public class Baoshu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n+1];
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            arr.add(i-1);
        }
        int res[] = new int[n];
        int len = n;
        for (int i = 1; i <= n; i++) {
            int num = a[i];
            int p = num % (n-i+1);
            int person = arr.get(p);
            arr.remove(p);
            res[person] = n-i+1;
        }
        for (int re : res) {
            System.out.println(re);
        }
    }
}
