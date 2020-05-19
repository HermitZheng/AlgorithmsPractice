package Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印
 * 其他行以此类推
 *
 * @author zhuqiu
 * @date 2020/3/13
 */
public class PrintTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        even.push(pRoot);
        int sign = 1;  // 记录奇偶数层
        while (!even.isEmpty()) {
            sign *= -1;
            ArrayList<Integer> list = new ArrayList<>();
            int size = even.size();
            for (int i = 0; i < size; i++) {
                TreeNode once = even.pop();
                if (sign == 1) {   // 当层数是偶数时,每次从even栈中出栈时进行打印
                    list.add(once.value);
                }
                odd.push(once);
            }
            size = odd.size();
            for (int i = 0; i < size; i++) {
                TreeNode twice = odd.pop();
                if (sign == -1) {   // 当层数是奇数时,每次从odd栈中出栈时进行打印
                    list.add(twice.value);
                }
                if (twice.left != null) {
                    even.push(twice.left);
                }
                if (twice.right != null) {
                    even.push(twice.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        PrintTree print = new PrintTree();
        ArrayList<ArrayList<Integer>> lists = print.Print(root);
        for (ArrayList<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

}
