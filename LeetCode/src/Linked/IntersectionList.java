package Linked;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 160
 *
 * @author zhuqiu
 * @date 2020/5/26
 */
public class IntersectionList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        /*
            第一轮走完时，让pA和pB互换路径，重新走一遍，这样一来，两条路径的长度差就抵消了
            如果两个指针相遇，则一定是在两个链表相交处
            如果第二轮走完还没有相交，则表示两条链表不相交
         */
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode_set(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();

        while (headA != null && headB != null) {
            if (set.contains(headA)) return headA;
            set.add(headA);
            if (set.contains(headB)) return headB;
            set.add(headB);
            headA = headA.next;
            headB = headB.next;
        }

        while (headA != null) {
            if (set.contains(headA)) return headA;
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            set.add(headB);
            headB = headB.next;
        }
        return null;
    }
}
