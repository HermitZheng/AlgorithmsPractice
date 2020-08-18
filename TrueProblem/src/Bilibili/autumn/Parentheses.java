package Bilibili.autumn;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/8/13
 */
public class Parentheses {

    public static void main(String[] args) {
        boolean b = new Parentheses().IsValidExp("]{()}");
        System.out.println(b);
    }


    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean IsValidExp (String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                stack.push('}');
                continue;
            }
            if (s.charAt(i) == '[') {
                stack.push(']');
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push(')');
                continue;
            }
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
