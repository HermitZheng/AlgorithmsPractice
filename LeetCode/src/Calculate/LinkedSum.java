package Calculate;

import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/4/12
 */
public class LinkedSum {


    //    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        ListNode temp = listNode;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        temp = listNode2;
        temp.next = new ListNode(6);
        temp = temp.next;
        temp.next = new ListNode(4);
//        temp = temp.next;
//        temp.next = new ListNode(0);
        ListNode result = new LinkedSum().test1(listNode, listNode2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), temp = result;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + flag;
            ListNode sumNode = new ListNode(sum % 10);
            flag = sum / 10;
            temp.next = sumNode;
            temp = sumNode;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return result.next;
    }


    public ListNode test1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), temp = result;
        int flag = 0;
        int len1=0, len2=0;
        l1 = reverse(l1, len1);
        l2 = reverse(l2, len2);
        while (l1 != null || l2 != null || flag != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + flag;
            ListNode sumNode = new ListNode(sum % 10);
            flag = sum / 10;
            temp.next = sumNode;
            temp = sumNode;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        ListNode reverse = reverse(result.next, flag);
        return reverse;
    }

    public ListNode reverse(ListNode head, int len) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        while (head.next != null) {
            ListNode temp = reverse(head.next, len);
            head.next.next = head;
            head.next = null;
            pre = temp;
            len++;
        }
        len++;
        return pre;
    }

    public int calculate(int num, int i) {
        return (int) (num * Math.pow(10, i));
    }
}
