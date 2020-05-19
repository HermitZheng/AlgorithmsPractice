package Tree;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/22
 */
public class RightView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode last = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!= null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                last = poll;
            }
            list.add(last.val);
        }
        return list;
    }
}
