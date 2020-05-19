package Tree;

/**
 * @author zhuqiu
 * @date 2020/4/3
 */
public class isAVL {

    public static void main(String[] args) {

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left-right) > 1) {
            return false;
        } else {
            return true;
        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(TreeDepth(root.left)+1, TreeDepth(root.right)+1);
    }
}
