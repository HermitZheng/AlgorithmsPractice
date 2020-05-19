package String;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/4/19
 */
public class countFrogs {

    public static void main(String[] args) {
        String s = "croakcrook";
        int i = new countFrogs().wrong(s);
        System.out.println(i);
    }

    public int minNumberOfFrogs(String croakOfFrogs) {

        return 0;
    }

    public int wrong(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() == 0) {
            return 0;
        }
        char[] chars = croakOfFrogs.toCharArray();
        Arrays.sort(chars);
        int i = 0, count = 0;
        while (chars[i] == 'a') {
            count++;
            i++;
        }
        int j = i;
        for (; i < j + count; i++) {
            if (chars[i] != 'c') {
                return -1;
            }
        }
        j = i;
        for (; i < j + count; i++) {
            if (chars[i] != 'k') {
                return -1;
            }
        }
        j = i;
        for (; i < j + count; i++) {
            if (chars[i] != 'o') {
                return -1;
            }
        }
        j = i;
        for (; i < j + count; i++) {
            if (chars[i] != 'r') {
                return -1;
            }
        }
        return count;
    }
}
