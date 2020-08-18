package Stack;

import java.util.Stack;

/**
 * leetcode 5470. 平衡括号字符串的最少插入次数
 *
 * @author zhuqiu
 * @date 2020/8/8
 */
public class MinInsertion {

    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count > 0) {
                    if (count % 2 == 1) {
                        count++;
                        res++;
                        res += count / 2;
                        count = 0;
                    }
                }
                if (!stack.isEmpty() && stack.size() % 2 != 0) {
                    res++;
                    stack.pop();
                }
                stack.push('(');
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    count++;
                    continue;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            res += stack.size();
        }
        if (count % 2 != 0) {
            count++;
            res++;
            res += count / 2;
        } else {
            res += count / 2;
        }
        return res;
    }
}
