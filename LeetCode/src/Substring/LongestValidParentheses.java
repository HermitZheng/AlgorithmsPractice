package Substring;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/4/13
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String parenthese = "()(())";
        int result = new LongestValidParentheses().longestValidParentheses(parenthese);
        System.out.println(result);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] split = s.split("");
        int[] dp = new int[split.length];
        int result = 0;
        for (int i = 1; i < split.length; i++) {
            if (split[i].equals(")")) {
                if (split[i-1].equals("(")){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && split[i - dp[i - 1] - 1].equals("(")) {
                    dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public int longestValidParentheses_stack(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
