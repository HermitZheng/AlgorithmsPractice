package stack;

/**
 * @author zhuqiu
 * @date 2020/2/17
 */
public class LinkStack {

    class StackNode {

        int no;

        int value;

        StackNode next;

        public StackNode(int value) {
            this.value = value;
        }

        public StackNode() {
        }

        @Override
        public String toString() {
            return "StackNode{" +
                    "no=" + no +
                    ", value=" + value +
                    '}';
        }
    }

    StackNode top;

    int maxSize;

    public LinkStack(int maxSize) {
        top = new StackNode();
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        if (top.next == null){
            return false;
        }
        return top.next.no == maxSize;
    }

    public boolean isEmpty() {
        return top.next == null;
    }

    public void push(int value) {
        if (isFull()){
            System.out.println("栈满，进栈失败！ value:{}" + value);
            return;
        }
        StackNode node = new StackNode(value);
        if (top.next == null) {
            node.no = 1;
            node.next = null;
            top.next = node;
            return;
        }
        node.no = top.next.no + 1;
        node.next = top.next;
        top.next = node;
    }

    public StackNode pop() {
        if (isEmpty()){
            System.out.println("栈空，出栈失败！");
            return null;
        }
        StackNode result = top.next;
        top.next = top.next.next;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("栈空，查值失败！");
            return 0;
        }
        return top.next.value;
    }

    public void list() {
        if (isEmpty()){
            System.out.println("栈空");
        }
        StackNode temp = top;
        while (temp.next != null) {
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }
}
