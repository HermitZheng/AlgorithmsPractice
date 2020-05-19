package Stack;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/3/10
 */
public class TwoStackForAQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        Integer pop;
        if (!stack2.isEmpty()){
            pop = stack2.pop();
        } else {
            if (stack1.isEmpty()){
                throw new RuntimeException();
            }else {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            pop = stack2.pop();
            }
        }

        return pop;
    }

    public static void main(String[] args) {
        TwoStackForAQueue queue = new TwoStackForAQueue();
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pop());
        }
    }
}
