package Tree;

/**
 * @author zhuqiu
 * @date 2020/4/3
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(3);
        TreeDepth instance = new TreeDepth();
        int depth = instance.TreeDepth(root);
        System.out.println(depth);
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
