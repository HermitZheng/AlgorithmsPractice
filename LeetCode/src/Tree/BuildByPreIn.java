package Tree;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/5/22
 */
public class BuildByPreIn {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        int[] preorder = {4, 1, 2, 3};
        int[] inorder = {1, 2, 3, 4};
        TreeNode res = new BuildByPreIn().buildTree(preorder, inorder);
        System.out.println(res);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (preorder.length==0 || inorder.length==0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int i=0;
        while (i < len && preorder[0] != inorder[i]) i++;

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, len), Arrays.copyOfRange(inorder, i+1, len));

        return root;
    }
}
