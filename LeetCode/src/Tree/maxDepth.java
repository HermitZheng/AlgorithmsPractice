package Tree;

import java.util.*;

/**
 * leetcode 104
 *
 * @author zhuqiu
 * @date 2020/5/19
 */
public class maxDepth {

    public int MaxDepth(TreeNode root) {    // 层序遍历
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode lastLevel = root;
        TreeNode visit;
        int depth = 0;
        queue.push(root);
        while (!queue.isEmpty()) {
            visit = queue.poll();
            if (visit.left != null) {
                queue.offer(visit.left);
            }
            if (visit.right != null) {
                queue.offer(visit.right);
            }
            if (visit == lastLevel) {   // 这一层遍历完了
                depth++;
                lastLevel = queue.peekLast();   // 队尾元素，即这一层最后一个被遍历的元素
            }
        }
        return depth;
    }

    public int maxDepth_(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth_(root.left), maxDepth_(root.right)) + 1;
    }

    public int maxDepth__(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
