package Tree;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @author zhuqiu
 * @date 2020/3/22
 */
public class PathSum {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return result;
        }
        list.add(root.value);
        target -= root.value;
        if (target >= 0) {
            if (target == 0 && root.left == null && root.right == null) {   // 只有值相等，且到达叶子结点，才算一条路径
                result.add(new ArrayList<>(list));
            }
            FindPath(root.left, target);
            FindPath(root.right, target);
            list.remove(list.size()-1);       // 清空公共的列表，让其他递归使用
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        PathSum instance = new PathSum();
        ArrayList<ArrayList<Integer>> arrayLists = instance.FindPath(root, 8);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }


}
