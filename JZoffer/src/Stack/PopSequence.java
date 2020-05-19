package Stack;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/3/22
 */
public class PopSequence {

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {3, 5, 4, 2, 1};
        PopSequence instance = new PopSequence();
        boolean b = instance.IsPopOrder(push, pop);
        System.out.println(b);
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0 || popA.length==0 || popA.length!=pushA.length) {
            return false;
        }
        Stack stack = new Stack();
        int sign = 0;
        for (int in : pushA) {
            stack.push(in);
            for (;sign<popA.length;) {
                int out = popA[sign];
                if (out != (int)stack.peek()) {
                    break;
                }
                if (out == (int)stack.peek()){
                    stack.pop();
                    sign++;
                    continue;
                }
            }
        }
        if (sign == popA.length) {
            return true;
        } else {
            return false;
        }
    }
}
