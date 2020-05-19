package Tree;

/**
 * @author zhuqiu
 * @date 2020/3/12
 */
/* 思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
 *      左子树的右子树和右子树的左子树相同即可，采用递归
 *      非递归也可，采用栈或队列存取各级子树根节点
 */
public class Symmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }
        return compareNode(pRoot.left, pRoot.right);
    }

    boolean compareNode(TreeNode left, TreeNode right) {

        if (left == null) return right==null;   // 左右都为空则为对称
        if (right == null) return false;        // 左子树不为空，但右子树为空，false
        if (left.value != right.value) return false;
        return compareNode(left.left, right.right) && compareNode(left.right, right.left);     // 左子树的左子树和右子树的右子树对比
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        Symmetrical symmetrical = new Symmetrical();
        boolean result = symmetrical.isSymmetrical(root);
        System.out.println(result);
    }
}
