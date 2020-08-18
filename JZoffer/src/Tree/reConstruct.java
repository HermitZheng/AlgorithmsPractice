package Tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *  * 例如：
 *  * 前序遍历 preorder = [3,9,20,15,7]
 *  * 中序遍历 inorder = [9,3,15,20,7]
 *
 * @author zhuqiu
 * @date 2020/3/13
 */
public class reConstruct {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {   // pre为先序序列， in为中序序列
        if (pre == null || in == null) {
            return null;
        }
        TreeNode root = recursive(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    public TreeNode recursive(int[] pre, int startPre, int endPre,
                              int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode node = new TreeNode(pre[startPre]);   // 先序遍历的第一个元素为根节点
        for (int i = startIn; i <= endIn; i++) {   // 循环直到在中序遍历中找到根节点
            if (in[i] == pre[startPre]) {
                /**
                 *  对于先序遍历，左子树是根节点（startPre）后一位开始，数量是中序遍历的开始位置startIn到中序的根节点 i 的元素数量
                 *  对于中序遍历，左子树是从startIn开始，到 i 为止（即 i-1）
                 */
                node.left = recursive(pre, startPre+1, startPre-startIn+i, in, startIn, i-1);
                /**
                 *  对于先序遍历，右子树是从左子树尾（即上文的endPre+1）开始，直到列表尾部（endPre）
                 *  对于中序遍历，右子树是从根节点（ i+1）开始，直到列表尾部
                 */
                node.right = recursive(pre, startPre-startIn+i+1, endPre, in, i+1, endIn);
                break;
            }
        }
        return node;
    }

    // 简化递归
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

    // 迭代
    public TreeNode buildTree_iter(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0 || inorder.length == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorder_index = 0;

        for (int i = 1; i < len; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inorder_index]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorder_index]) {
                    node = stack.pop();
                    inorder_index++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;
    }
}
