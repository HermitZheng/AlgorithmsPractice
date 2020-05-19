package Link;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/3/11
 */

public class LastKNode {

    public ListNode FindKByStack(ListNode head, int k) {
        if (head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        ListNode result = null;
        for (int i = 0; i < k; i++) {
            if (stack.isEmpty()){
                return null;
            }
            result = stack.pop();
        }
        System.out.println(result.toString());
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(5);
        LastKNode method = new LastKNode();
        ListNode node = method.FindKByStack(listNode, 5);
        System.out.println(node.toString());
    }
}
