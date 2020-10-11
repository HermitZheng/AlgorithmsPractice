package Tencent;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/8/23
 */
public class StringRange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = in.nextInt();
        System.out.println(method(s, k));
    }

    public static String method(String s, int k) {
        Set<String> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String temp = "";
            for (int j = i; j < (i + k); j++) {
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
        return list.get(k - 1);
    }
}
