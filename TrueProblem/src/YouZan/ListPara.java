package YouZan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/8/20
 */
public class ListPara {


    class ListNode {
        int val;
        ListNode next = null;
    }


    /**
     * 判断是否为回文链表
     *
     * @param head ListNode类 链表头
     * @return bool布尔型
     */
    public boolean isPalindrome(ListNode head) {
        // write code here

        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head;
        int len = 1;
        while (fast != null && fast.next != null) {
            len++;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表长度为偶数
        if (fast == null) {
            len = len-1;
        } else {
            // 链表长度为奇数
            len = len-1;
            slow = slow.next;
        }
        fast = head;
        int i = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        while (slow != null) {
            left[i] = fast.val;
            right[i] = slow.val;
            fast = fast.next;
            slow = slow.next;
        }

        for (i=0; i<len; i++) {
            if (left[i] != right[len-i-1]) {
                return false;
            }
        }
        return true;
    }

    public ListNode Reverse(ListNode head) {
        ListNode pre = head;
        while (head.next != null){
            ListNode temp = Reverse(head.next);
            head.next.next = head;
            head.next = null;
            pre = temp;
        }
        return pre;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }

    public boolean method(ListNode head) {
        // write code here
        ListNode left = head;
        ListNode right = reverse(head);
        while (left != right) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
