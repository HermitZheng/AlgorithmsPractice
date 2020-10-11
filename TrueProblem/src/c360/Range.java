package c360;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/22
 */
public class Range {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] acts = new int[m];
        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }

        for (int i = 0; i < m; i++) {
            acts[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int act = acts[i];
            if (act == 1) {
                Integer remove = list.remove(0);
                list.add(remove);
                continue;
            }
            int count = 1;
            while (acts[i+1] == 2) {
                count++;
                i++;
            }
//            i--;
            if (count % 2 == 0) {
                continue;
            } else {
                swap(list);
            }
        }

        boolean flag = true;
        for (Integer integer : list) {
            if (!flag) {
                System.out.print(" ");
            }
            System.out.print(integer);
            flag = false;
        }
    }

    private static void swap(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i+=2) {
            int temp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, temp);
        }
    }
}
