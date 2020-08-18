package Tree.level;

import Tree.TreeNode;
import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/7/29
 */
public class LevelPrint_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (flag) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
