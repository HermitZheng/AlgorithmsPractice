package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author zhuqiu
 * @date 2020/3/12
 */
public class LevelTraverse {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;       // 当根节点为空时，返回空列表
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();                // 记录队列的原长度，以便之后的循环只遍历树的一层
            for (int i = 0; i < size; i++) {        // 遍历这一层
                TreeNode node = queue.poll();
                list.add(node.value);
                if (node.left != null) {            // 将左右子树添加到队列尾部
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);          // 将这一层的结果添加到结果集中
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        LevelTraverse level = new LevelTraverse();
        ArrayList<ArrayList<Integer>> lists = level.Print(root);
        for (ArrayList<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }


}
