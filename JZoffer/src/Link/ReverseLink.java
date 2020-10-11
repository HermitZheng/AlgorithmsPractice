package Link;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author zhuqiu
 * @date 2020/3/11
 */

public class ReverseLink {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), pre = dummy, next;
        dummy.next = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        head = dummy.next;
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k; j++) {
                next = head.next;
                head.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pointer = head;
        pointer = pointer.next;
        ListNode pre = head;
        ListNode result = null;
        while (pre.next != null){
            pre.next = result;
            result = pre;
            pre = pointer;
            pointer = pointer.next;
        }
        pre.next = result;
//        result = result.next;
        return pre;

    }

    public ListNode Reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        while (head.next != null){
            ListNode temp = Reverse(head.next);
            head.next.next = head;
            head.next = null;
            pre = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(5);
//        while (listNode != null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ReverseLink reverse = new ReverseLink();
        ListNode head = reverse.Reverse(listNode);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
