package Tree;


/**
 * leetcode 701
 *
 * @author zhuqiu
 * @date 2020/5/11
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode p = root, parent = root;
        while (p != null) {
            parent = p;
            p = p.val > val ? p.left : p.right;
        }
        if (parent.val > val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        return root;
    }

    public TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertRecursive(root.left, val);
        } else {
            root.right = insertRecursive(root.right, val);
        }
        return root;
    }
}
