package Tree;

/**
 * @author zhuqiu
 * @date 2020/5/31
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
