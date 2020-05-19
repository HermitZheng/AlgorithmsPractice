package Tree;

import java.util.LinkedList;

/**
 * @author zhuqiu
 * @date 2020/5/15
 */
public class Test {

    class TreeNode {
        LinkedList<Integer> valList;
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            valList = new LinkedList<>();
            valList.add(val);
        }
        void add(int val) {
            valList.add(val);
        }

    }

    public void insert(TreeNode root, int val) {
        TreeNode temp = root, parent = root;
        while (temp != null) {
            parent = temp;
            if (temp.value > val) temp = temp.left;
            else if(temp.value < val) temp = temp.right;
            else temp.add(val);
        }
        if (parent.value > val) parent.left = new TreeNode(val);
        else if (parent.value < val) parent.right = new TreeNode(val);
        else parent.add(val);
    }
}
