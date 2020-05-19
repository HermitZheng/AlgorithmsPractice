package Linked;

/**
 * leetcode 19
 *
 * @author zhuqiu
 * @date 2020/5/11
 */
public class Delete {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head, pre = node;
        if (head.next == null && n == 1) return null;
//        for (int i=0; i<n; i++) {
//            node = node.next;
//        }
//        if (node == null) return head.next;
//        while (node.next != null) {
//            node = node.next;
//            pre = pre.next;
//        }

        int i=0;
        while (i < n || node.next != null) {
            if (i++ < n) {
                node = node.next;
                if (node == null) return head.next;
            } else {
                node = node.next;
                pre = pre.next;
            }
        }
        pre.next = pre.next.next;
        return head;
    }
}
