package Tree;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author zhuqiu
 * @date 2020/3/13
 */
public class GetNextNode {



    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }

        if (pNode.right != null){  // 该节点有右分支
            pNode = pNode.right;
            while (pNode.left != null){  // 直到找到右子树的最左分支结点
                pNode = pNode.left;
            }
            return pNode;

        } else {        // 没有右分支，则认为应向上返回
            if (pNode.next == null){  // 是根结点
                return null;
            }
            do {
                if (pNode.next.left == pNode){   // pNode是左子树，则返回父节点
                    return pNode.next;
                }
                pNode = pNode.next;    // 如果是右子树，对父节点进行判断
            } while (pNode.next != null);
            return null;     // 一直向上直到根结点，则整棵树已经遍历完成，返回null
        }
    }

    public static void main(String[] args) {

        GetNextNode method = new GetNextNode();
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeLinkNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }
}
