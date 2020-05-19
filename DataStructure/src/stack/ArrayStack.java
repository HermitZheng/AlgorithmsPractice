package stack;

/**
 * @author zhuqiu
 * @date 2020/2/17
 */
public class ArrayStack {

    int maxSize;

    // 数组模拟栈
    int[] stack;

    // 栈顶，初始化为-1
    int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull() == true) {
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty() == true) {
            throw new RuntimeException("栈空!");
        }
        int result = stack[top];
        top--;
        return result;
    }

    //从栈顶开始遍历
    public void list() {
        if (isEmpty() == true){
            throw new RuntimeException("栈空!");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]: %d", i, stack[i]);
        }
    }
}
