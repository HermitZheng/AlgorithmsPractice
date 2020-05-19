package Tree;

/**
 * @author zhuqiu
 * @date 2020/3/22
 */
public class HasSubTree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;
        if (root1 != null && root2 != null) {      // 前提是两树都不为空
            if (root1.value == root2.value) {      // 根节点相同，尝试进行比较
                result = isContain(root1, root2);
            }
            if (!result) {
                result = isContain(root1.left, root2);   // 根节点不同，将根节点的左右子树与root2进行比较
            }
            if (!result) {
                result = isContain(root1.right, root2);
            }
        }
        return result;
//        return isContain(root1, root2) || isContain(root1.left, root2) || isContain(root1.right, root2);
    }

    public boolean isContain(TreeNode root1, TreeNode root2) {
        if (root2 == null) {   // root2已遍历完都相同，返回true。注意：上下两个if语句不能颠倒
            return true;
        }
        if (root1 == null) {   // root1已遍历完，但是root2仍然有结点，返回false （隐含条件root2!=null，上面已经if过了）
            return false;
        }
        if (root1.value != root2.value) {   // 当前节点不同，返回false
            return false;
        }
        return isContain(root1.left, root2.left) && isContain(root1.right, root2.right);      // 分别对左右子树进行下一层比较
    }
}
