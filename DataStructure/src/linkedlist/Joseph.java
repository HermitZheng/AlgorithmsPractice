package linkedlist;

/**
 * @author zhuqiu
 * @date 2020/2/16
 */
public class Joseph {

    // 环形单向链表
    public static void main(String[] args) {
        CircleSingleLinkedList circle = new CircleSingleLinkedList();
        circle.add(5);
        circle.show();
        circle.popNode(2, 4, 5);
    }


}

class CircleSingleLinkedList {

    private Node first = new Node(-1);

    /**
     * 计算出圈的队列顺序
     *
     * @param startNum 从第几个开始数
     * @param countNum 每次数几个
     * @param nums     一共有几个结点
     */
    public void popNode(int startNum, int countNum, int nums) {

        if (first == null || startNum < 1 || countNum < 1){
            System.out.println("数据或输入有误！");
            return;
        }

        Node help = first;
        while (help.next != first){
            help = help.next;
        }
        for (int i = 0; i < startNum-1; i++) {
            help = help.next;
            first = first.next;
        }

        while (help != first) {
            for (int i = 0; i < countNum-1; i++) {
                help = help.next;
                first = first.next;
            }
            System.out.println(first.toString());
            first = first.next;
            help.next = first;
        }
        System.out.println(first.toString());
    }

    public void delete(int num) {
        if (num < 1) {
            System.out.println("输入错误");
            return;
        }
        Node temp = first;
        for (int i = 0; i < num-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return;
    }

    public void add(int nums) {
        if (nums <= 0) {
            return;
        }
        // 辅助指针，用于构建环形
        Node cur = null;

        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(node);
                node.setNext(first);
                cur = node;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("链表为空");
        }
        System.out.println("开始遍历");
        Node current = first;
        do {
            System.out.println(current.toString());
            current = current.next;
        } while (current != first);
        System.out.println("结束遍历");
    }

}

class Node {

    int no;

    Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}

