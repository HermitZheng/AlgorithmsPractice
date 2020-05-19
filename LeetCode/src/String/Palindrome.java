package String;

/**
 * leetcode 680
 *
 * @author zhuqiu
 * @date 2020/5/19
 */
public class Palindrome {

    public boolean validPalindrome(String s) {
        int len = s.length();
//        if (len == 0) return true;
        return valid(s, 0, len-1, false);
    }

    public boolean valid(String s, int left, int right, boolean flag) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            else if (!flag) {
                return valid(s, left+1, right, true) || valid(s, left, right-1, true);
            } else {
                return false;
            }
        }
        return true;
    }
}
