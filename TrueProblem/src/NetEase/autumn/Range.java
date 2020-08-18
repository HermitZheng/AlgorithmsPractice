package NetEase.autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/8
 */
public class Range {

    static int[] pos = new int[100001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i=0; i<m; i++) {
            arr[i] = in.nextInt();
            pos[arr[i]]++;
        }
        method(arr, n);
    }

    private static void method(int[] arr, int n) {
        List<Integer> list = new ArrayList<>(n);
//        List<Integer> temp = new ArrayList<>(arr.length);
        int k = 0;
        for (int i = 1; i <= n; i++) {
            // 所剩必须全部由arr填满
            if (arr.length - k >= n - list.size()) {
                while (k < arr.length) {
                    list.add(arr[k++]);
                }
                break;
            }
            if (pos[i] == 1 && k < arr.length && arr[k] == i) {
                list.add(arr[k++]);
                continue;
            }
            while (k < arr.length && pos[i] == 0 && arr[k] <= i) {
                list.add(arr[k++]);
            }

            if (arr.length - k > n - list.size()) {
                while (k < arr.length) {
                    list.add(arr[k++]);
                }
                break;
            }

            if (pos[i] == 0 && (k >= arr.length || arr[k] > i)) {
                list.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
