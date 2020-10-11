package Alibaba;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/9/1
 */
public class Demo {

    public static void main(String[] args) {
        String s = "acc";

        List<String> list = range(s);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    public static List<String> range(String s) {
        Set<String> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String temp = "";
            for (int j = i; j < (i + s.length()); j++) {
                if (j >= len) {
                    break;
                }
                temp += s.charAt(j);
                set.add(temp);
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list, Comparator.naturalOrder());
        return list;
    }
}
