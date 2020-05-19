package Tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
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
}
