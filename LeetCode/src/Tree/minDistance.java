package Tree;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/5/20
 */
public class minDistance {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        int res = new minDistance().getMinimumDifference(root);
        System.out.println(res);
    }

    private int min = Integer.MAX_VALUE / 2;
    public int getMinimumDifference(TreeNode root) {
        mid(root, new TreeNode(min));
        return min;
    }

    public TreeNode mid(TreeNode node, TreeNode pre) {  // 中序
        if (node != null) {
            pre = mid(node.left, pre);
            min = Math.min(min, Math.abs(node.val-pre.val));
            pre = mid(node.right, node);    // 注意：node变成下一个结点的pre了
        }
        return pre;
    }

    public int getMinimumDifference__(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE >> 1;
        int temp = min;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            min = Math.min(min, Math.abs(root.val-temp));
            temp = root.val;
            root = root.right;
        }
        return min;
    }
}
