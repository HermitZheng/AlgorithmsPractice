package Basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zhuqiu
 * @date 2020/5/4
 */
public class Guess_1005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            arr[i] = num;
            map.put(num, 0);
        }
        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            int x = arr[i];
            while (x > 1) {
                if (x % 2 == 1) x = (3 * x + 1) / 2;
                else x /= 2;
                map.put(x, 1);
            }
        }
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (map.get(arr[i]) == 0){
                if (flag) System.out.print(" ");
                System.out.print(arr[i]);
                flag = true;
            }

        }
    }
}
