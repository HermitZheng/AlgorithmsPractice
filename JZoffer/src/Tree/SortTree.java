package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * @author zhuqiu
 * @date 2020/3/13
 */
public class SortTree {

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        midOrder(pRoot, queue);
        TreeNode result = null;
        for (int i = 0; i < k; i++) {
            result = queue.poll();
        }
        return result;
    }

    public void midOrder(TreeNode root, Queue<TreeNode> queue){
        if (root == null){
            return;
        }
        midOrder(root.left, queue);
        queue.offer(root);
        midOrder(root.right, queue);
        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        SortTree method = new SortTree();
        TreeNode node = method.KthNode(root, 1);
        System.out.println(node);
    }
}
