package Design;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/19
 */
public class Order {

    public List<List<String>> displayTable(List<List<String>> orders) {
        if (orders == null || orders.size() == 0) {
            return null;
        }
        TreeMap<Integer, HashMap<String, Integer>> table = new TreeMap<>();
        Collections.sort(orders, Comparator.comparing(o -> o.get(1)));
        int num = Integer.parseInt(orders.get(0).get(1));
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            if (num != tableNum) {
                num = tableNum;
            }
            String[] dish = order.get(2).split(" ");
            table.computeIfAbsent(num, integer -> new HashMap<>());
            for (int i = 0; i < dish.length; i++) {
                table.get(num).putIfAbsent(dish[i], 1);
                table.get(num).put(dish[i], table.get(num).get(dish[i]) + 1);
            }
        }
        List<String> dishes = new ArrayList<>();
        dishes.add("Table");
        List<List<String>> lists = new ArrayList<>();
        return null;
    }
}
