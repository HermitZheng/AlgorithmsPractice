package NetEase;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class MagicTower {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int def = in.nextInt();
        int[] anti = new int[n];
        for (int i = 0; i < n; i++) {
            anti[i] = in.nextInt();
        }
        int[] dmg = new int[n];
        for (int i = 0; i < n; i++) {
            dmg[i] = in.nextInt();
        }

        int hurt = 0;

        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < n; i++) {
            map.put(anti[i], dmg[i]);
        }

        Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
        while (!map.isEmpty() && entry.getKey() < def) {
            def += 1;
            entry = map.pollFirstEntry();
        }

        while (!map.isEmpty()) {
            if (def <= entry.getKey()){
                hurt += entry.getValue();
            }
            def++;
            entry = map.pollFirstEntry();
        }
        System.out.println(hurt);

    }
}
