package Design;

/**
 * @author zhuqiu
 * @date 2020/6/7
 */
public class BrowserHistory {

    class ListNode<T> {
        T val;
        ListNode next;
        ListNode pre;

        ListNode(T x) {
            val = x;
        }
    }

    ListNode<String> history;
    ListNode<String> pre;
    ListNode<String> cur;
    int index;

    public BrowserHistory(String homepage) {
        history = new ListNode<>(homepage);
        history.pre = null;
        cur = history;
    }

    public void visit(String url) {
        pre = cur;
        cur.next = new ListNode(url);
        cur = cur.next;
        cur.pre = pre;
    }

    public String back(int steps) {
        int i = 0;
        while (i < steps && pre != null) {
            cur = pre;
            pre = pre.pre;
            i++;
        }
        return cur.val;
    }

    public String forward(int steps) {
        int i = 0;
        while (i < steps && cur.next != null) {
            pre = cur;
            cur = cur.next;
            i++;
        }
        return cur.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */