package Stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * @author zhuqiu
 * @date 2020/3/22
 */
public class StackContainMin {

    private Stack stack = new Stack();
    private Stack min = new Stack();
    private Stack max = new Stack();

    public static void main(String[] args) {
        StackContainMin instance = new StackContainMin();
        instance.push(3);
        instance.push(4);
        instance.push(2);
        instance.push(3);
        instance.pop();
        System.out.println(instance.min());
        instance.pop();
        System.out.println(instance.min());
        instance.pop();
        System.out.println(instance.min());
    }

    public void push(int node) {
        if (stack.isEmpty()){
            min.push(node);
            max.push(node);
            stack.push(node);
            return;
        } else if (node>(int)max.peek()){
            max.push(node);
            stack.push(node);
        } else if (node<(int)min.peek()){
            min.push(node);
            stack.push(node);
        } else {
            stack.push(node);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int pop = (int) stack.pop();
        if (pop == (int)min.peek()){
            min.pop();
        }
        if (pop == (int)max.peek()){
            max.pop();
        }
    }

    public int top() {
        return (int)max.peek();
    }

    public int min() {
        return (int)min.peek();
    }
}
