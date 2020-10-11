package Link;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表
 * 当然我们需要合成后的链表满足单调不减规则。
 * @author zhuqiu
 * @date 2020/3/11
 */
public class MergeLink {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            if (list2 == null){
                return null;
            }
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (list1 != null || list2 != null){
            if (list1 == null){
                temp.next = list2;
                break;
            }
            if (list2 == null){
                temp.next = list1;
                break;
            }
            if (list1.val >= list2.val){
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
                continue;
            } else {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
                continue;
            }
        }
        result = result.next;
        return result;
    }

}
