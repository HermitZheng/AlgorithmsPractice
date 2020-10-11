package DuXiaoMan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/9/20
 */
public class Painting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String have = in.nextLine();
        String need = in.nextLine();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : have.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char c : need.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                count++;
                map.put(c, map.get(c)-1);
            }
        }
        System.out.println(count);
    }
}
