package Bilibili.old;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # : a:3#b:8#c:9
 *
 * to
 *
 * 3
 * a 3
 * b 8
 * c 9
 *
 * @author zhuqiu
 * @date 2020/8/13
 */
public class PairDivide {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char pairDivide = s.charAt(0);
        char elemDivide = s.charAt(2);

        int i = 4;
        List<String> list = new ArrayList<>();
        outer:
        while (i < s.length()) {
            String temp;
            if (i >= s.length() || s.charAt(i) == ' ') {
                continue;
            }
            int mark = i;
            while (i < s.length() && s.charAt(i) != elemDivide) {
                if (s.charAt(i) == pairDivide) {
                    i++;
                    continue outer;
                }
                i++;
            }
            temp = s.substring(mark, i++);

            if (i >= s.length() || s.charAt(i) == ' ') {
                continue;
            }
            mark = i;
            while (i < s.length() && s.charAt(i) != pairDivide) {
                i++;
            }
            list.add(temp + " " + s.substring(mark, i++));
        }
        System.out.println(list.size());
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}
