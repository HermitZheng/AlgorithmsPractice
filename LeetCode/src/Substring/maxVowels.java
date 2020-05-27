package Substring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuqiu
 * @date 2020/5/24
 */
public class maxVowels {

    public static void main(String[] args) {
        int weallloveyou = new maxVowels().maxVowels("weallloveyou", 7);
        System.out.println(weallloveyou);
    }

    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int slen = s.length();
        int maxk = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < vowels.length(); i++) {
            set.add(vowels.charAt(i));
        }
        if (slen < k) {
            for (int i = 0; i < slen; i++) {
                char c = s.charAt(i);
                if (set.contains(c)) maxk++;
            }
            return maxk;
        }
        int temp = 0, left = 0, right = 0;
        for (; right < k; right++) {
            if (set.contains(s.charAt(right))) temp++;
        }

        while (right < slen) {
            if (maxk == k) return maxk;
            if (temp > maxk) maxk = temp;

            if (set.contains(s.charAt(right))) temp++;
            if (set.contains(s.charAt(left))) temp--;
            right++;
            left++;
        }
        return maxk > temp ? maxk : temp;
    }
}
