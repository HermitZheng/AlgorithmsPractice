package MeiTuan.at;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/8/22
 */
public class TeamDivide {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < x + y; i++) {
            int power = in.nextInt();
            map.put(power, i);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        boolean flag = true;
        boolean[] res = new boolean[x+y];

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer num = next.getValue();
            res[num] = flag;
            flag = !flag;
        }



    }
}
