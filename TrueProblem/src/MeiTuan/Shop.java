package MeiTuan;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/23
 */
public class Shop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            list[i][0] = in.nextInt();
            list[i][1] = in.nextInt();

        }
        Arrays.sort(list, Comparator.comparingInt(o -> o[0]));
        double sum = 0;
        int i = k-1;
        for (; i > 0; i--) {
            while (list[n-1][1] == 2) {
                n--;
            }
            sum += list[n-1][0] / 2.00;
            list[n-1][0] = -1;
            n--;
        }
        double count = 0;
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for (int j = 0; j < list.length; j++) {
            int item = list[j][0];
            if (item != -1) {
                if (list[j][1] == 1) flag = true;
                count += item;
                min = Math.min(min, item);
            }
        }
        if (flag == true) {
            count -= min / 2.00;
        }
        sum += count;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(sum));
    }
}
