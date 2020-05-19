package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author zhuqiu
 * @date 2020/3/22
 */
public class PrintTree_2 {

    public static void main(String[] args) {
        PrintTree_2 print = new PrintTree_2();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        ArrayList<Integer> lists = print.PrintFromTopToBottom(root);
        for (Integer num : lists) {
            System.out.println(num);
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = (TreeNode) queue.poll();
            list.add(poll.value);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return list;
    }
}
