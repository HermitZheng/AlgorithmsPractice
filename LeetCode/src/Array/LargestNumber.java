package Array;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/5/16
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] cost = {6,10,15,40,40,40,40,40,40};
        String s = new LargestNumber().largestNumber(cost, 47);
        System.out.println(s);
    }

    public String largestNumber(int[] cost, int target) {
        int len = cost.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(i+1, cost[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        int sum = 0;
        int i = 0;
        StringBuilder res = new StringBuilder();
        List<String> resList = new ArrayList<>();
        int flag = i, flagNum = 0;
        outer:
        while (sum < target) {
            boolean sign = false;
            int num = list.get(i).getValue();
            List<Integer> indexList = new ArrayList<>();
            indexList.add(list.get(i).getKey());
            while (i < list.size()-1 && list.get(++i).getValue() == num) {
                indexList.add(list.get(i).getKey());
            }
            int k = indexList.size()-1;
            int index = indexList.get(k);

            while (num > (target-sum)) {
                if (--k < 0) break;
                index = indexList.get(k);
            }
            int count = (target-sum) / num;
            sum += count * num;
            for (int j = 0; j < count; j++) {
//                res.append(index);
                resList.add(index+"");
                sign = true;
            }
            if (sign) {
                flagNum = num;
                flag = i;
            }
            if (target == sum) break;

            if (i == list.size()-1) {
//                res.deleteCharAt(res.length()-1);
                if (resList.size() == 0) return "0";
                resList.remove(resList.size()-1);
                i = flag;
                sum -= flagNum;
            }
        }
        Collections.sort(resList);
        Collections.reverse(resList);
        for (String s : resList) {
            res.append(s);
        }
        return res.toString();
    }
}
