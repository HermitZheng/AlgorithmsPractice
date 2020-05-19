package Tree;

/**
 * @author zhuqiu
 * @date 2020/3/13
 */
public class Mirror {

    public void Mirror(TreeNode root) {
        if (root == null ) {
            return;
        }
        postOrder(root);
        return;
    }

    public void exchange(TreeNode root) {
        if (root == null ) {
            return;
        }
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        exchange(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);

        Mirror mirror = new Mirror();
        mirror.Mirror(root);
        System.out.println(root.toString());
    }

}
