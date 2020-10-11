package Tree;

/**
 * @author zhuqiu
 * @date 2020/9/2
 */
public class Depth {

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public boolean isBalance(TreeNode root) {

        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
