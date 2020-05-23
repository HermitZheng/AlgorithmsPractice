package Tree;

/**
 * @author zhuqiu
 * @date 2020/5/20
 */
public class isBalance {



    public boolean isBalanced_rec(TreeNode root) {
        if (root == null) return true;
        if ((Math.abs(depth(root.left) - depth(root.right)) > 1)) return false;
        return isBalanced_rec(root.left) && isBalanced_rec(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
