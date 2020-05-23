package Tree;

/**
 * leetcode 226
 *
 * @author zhuqiu
 * @date 2020/5/19
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    public TreeNode mirrorTree_(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
