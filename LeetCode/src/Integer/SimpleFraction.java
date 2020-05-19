package Integer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhuqiu
 * @date 2020/5/16
 */
public class SimpleFraction {

    public static void main(String[] args) {
        List<String> list = new SimpleFraction().simplifiedFractions(6);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        Set<Double> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && j != 1) continue;
                double num = j / (double)i;
                if (set.contains(num)) continue;
                else set.add(num);
                String s = j + "/" + i;
                list.add(s);
            }
        }
        return list;
    }
}
