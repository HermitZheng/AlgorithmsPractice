package c360;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/8/24
 */
public class MagicTower {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();


        List<Long> add = new ArrayList<>();
        List<Long> item = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long temp = in.nextInt();

            int isItem = in.nextInt();

            if (isItem == 0) {
                add.add(temp);
            } else {
                item.add(temp);
            }
        }


        long sum = 0;

        Collections.sort(item, Comparator.comparingLong(o -> -o));

        for (Long value : add) {
            sum += value;
        }

        for (Long value : item) {
            if (sum * 2 >= sum + value) {
                sum *= 2;
            } else {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
