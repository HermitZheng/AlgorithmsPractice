package Tree;

/**
 * @author zhuqiu
 * @date 2020/5/16
 */
public class GoodNode {

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        count += isGood(root.left, root.val) + isGood(root.right, root.val);
        return count;
    }

    public int isGood(TreeNode root, int max) {
        if (root == null) return 0;
        if (root.val >= max) {
            return isGood(root.left, root.val) + isGood(root.right, root.val) + 1;
        } else {
            return isGood(root.left, max) + isGood(root.right, max);
        }
    }
}
