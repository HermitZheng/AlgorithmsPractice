package Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1371
 *
 * @author zhuqiu
 * @date 2020/5/20
 */
public class LongestStringWithVowels {

    private static final String vowels = "aeiou";

    public int findTheLongestSubstring(String s) {
        int len = s.length(), vlen = vowels.length();
        Map<Integer, Integer> map = new HashMap<>();
        int maxsize = 0;
        int statue = 0;
        map.putIfAbsent(0, -1);
        for (int i = 0; i < len; i++) {
            for (int k = 0; k < vlen; k++) {
                if (s.charAt(i) == vowels.charAt(k)) {
                    statue ^= (1 << (vlen - k - 1));
                    break;
                }
            }
            if (map.containsKey(statue)) {
                maxsize = Math.max(maxsize, i - map.get(statue));
            }
            map.putIfAbsent(statue, i);
        }
        return maxsize;
    }
}
