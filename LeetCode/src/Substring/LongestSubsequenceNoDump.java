package Substring;

import java.util.HashSet;

/**
 * @author zhuqiu
 * @date 2020/4/10
 */
public class LongestSubsequenceNoDump {

    public static void main(String[] args) {
        int result = new LongestSubsequenceNoDump().optimize("dvdf");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet();
        int max = 0;
        String[] list = s.split("");
        for (int i = 0, j = 0; i < list.length; i++) {
            if (set.contains(list[i])) {
                max = Math.max(max, set.size());
                set.clear();
                while (!list[j].equals(list[i])) {
                    j++;
                }
                i = ++j;
            }
            set.add(list[i]);
        }
        max = Math.max(max, set.size());
        return max;
    }

    public int optimize(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int max = 0;
        for (; left < chars.length;) {
            for (int right = left; right < chars.length; right++) {
                if (chars[left] == chars[right]) {
                    max = Math.max(max, right - left);
                    left = right+1;
                    break;
                }
            }
        }
        return Math.max(max, chars.length-left);
    }

}
