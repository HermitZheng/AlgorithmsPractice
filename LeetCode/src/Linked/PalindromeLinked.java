package Linked;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhuqiu
 * @date 2020/8/25
 */
public class PalindromeLinked {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public boolean isPalindrome__(ListNode head) {
        ListNode slow = head, fast = head;

        Deque<Integer> deque = new LinkedList<>();

        while (fast != null && fast.next != null) {
            deque.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != deque.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
