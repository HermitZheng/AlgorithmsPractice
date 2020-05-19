package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhuqiu
 * @date 2020/4/26
 */
public class MergeKLists {

//    Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            heap.offer(list);
        }
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            temp.next = poll;
            temp = poll;
            if (poll.next != null) {
                heap.offer(poll.next);
            }
        }
        return result.next;
    }
}
