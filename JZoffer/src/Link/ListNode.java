package Link;

/**
 * @author zhuqiu
 * @date 2020/3/10
 */

public class ListNode {
    public int val;
    public ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Link.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
