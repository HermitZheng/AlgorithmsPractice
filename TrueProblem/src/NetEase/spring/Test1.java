package NetEase.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] dis = new int[n-1];
        ArrayList<Integer> arrayList = new ArrayList(n-1);
        for (int i = 0; i < n; i++) {
            arrayList.add(arr[i+1] - arr[i]);
        }

        if (arrayList.contains(0)) {
            System.out.println(-1);
            return;
        }


    }
}
