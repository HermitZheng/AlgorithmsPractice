package String;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/5/16
 */
public class LongestChars {

    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        int i = new LongestChars().maxPower(s);
        System.out.println(i);
    }

    public int maxPower_sb(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        Integer value = list.get(list.size() - 1).getValue();
        return value;
    }

    public int maxPower(String s) {
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == s.charAt(i-1)) dp[i] = dp[i-1]+1;
            else dp[i] = 1;
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}
