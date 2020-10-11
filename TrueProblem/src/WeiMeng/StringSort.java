package WeiMeng;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhuqiu
 * @date 2020/9/6
 */
public class StringSort {

    public static void main(String[] args) {
        String[] list = {"1.1.1", "1.1.2.10", "1.1.3", "1.1.2.2", "1.20.1", "1.10.1", "1.2.2", "1.3.0"};
        String[] res = new StringSort().sortMethod(list);

        for (String s : res) {
            System.out.print(s + " ");
        }
    }

    /**
     * @param stringArray string字符串一维数组
     * @return string字符串一维数组
     */
    public String[] sortMethod(String[] stringArray) {
        // write code here
        Arrays.sort(stringArray, (s1, s2) -> {
            String[] a1 = s1.split("\\.");
            String[] a2 = s2.split("\\.");

            for (int n = 0; n < Math.max(a1.length, a2.length); n++) {
                int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
                int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
                if (i < j) {
                    return 1;
                } else if (i > j) {
                    return -1;
                }
            }
            return 0;
        });
        return stringArray;
    }
}
