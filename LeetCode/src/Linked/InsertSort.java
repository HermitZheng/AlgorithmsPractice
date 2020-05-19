package Linked;

/**
 * @author zhuqiu
 * @date 2020/5/10
 */
public class InsertSort {

    // [-1,5,3,4,0]
    public static void main(String[] args) {
        int[] list = {-1, 5, 3, 4, 0};
        ListNode head = new ListNode(list[0]), temp = head;
        for (int i = 1; i < list.length; i++) {
            temp.next = new ListNode(list[i]);
            temp = temp.next;
        }
        new InsertSort().insertionSortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head.next, pre = head;
        while (node != null) {
            // 当前节点不需要排序，则next
            if (node.val >= pre.val) {
                pre = node;
                node = node.next;
                continue;
            }
            // pre 记录当前节点及下一个节点的位置
            pre.next = node.next;
            ListNode temp = head;
            // node比头结点大时，排到第一个
            if (temp.val >= node.val) {
                node.next = temp;
                head = node;
                node = pre.next;
                continue;
            }
            // 寻找插入位置
            while (temp.next.val < node.val) {
                temp = temp.next;
            }
            // node插入
            node.next = temp.next;
            temp.next = node;
            // 准备排序下一个元素
            node = pre.next;
        }
        return head;
    }
}
