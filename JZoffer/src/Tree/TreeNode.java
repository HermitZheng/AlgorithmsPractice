package Tree;

/**
 * @author zhuqiu
 * @date 2020/3/12
 */
public class TreeNode {

    public int value = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNode() {
    }

    public static void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void midOrder(TreeNode root){
        if (root == null){
            return;
        }
        midOrder(root.left);
        System.out.print(root.value + " ");
        midOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }
}
