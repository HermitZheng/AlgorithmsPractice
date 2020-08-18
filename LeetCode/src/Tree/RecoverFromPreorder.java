package Tree;

/**
 * leetcode 1028
 *
 * @author zhuqiu
 * @date 2020/6/18
 */
public class RecoverFromPreorder {

    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        TreeNode node = new RecoverFromPreorder().recoverFromPreorder(s);
    }

    int index = 0;

    public TreeNode recoverFromPreorder(String S) {
        return recursive(S, 0);
    }

    public TreeNode recursive(String s, int depth) {
        int level = 0;
        while (index + level < s.length() && s.charAt(index + level) == '-') {
            level++;
        }

        if (level != depth) return null;
        int next = index + level;

        while (next < s.length() && s.charAt(next) != '-') {
            next++;
        }
        int val = Integer.parseInt(s.substring(index+level, next));

        index = next;
        TreeNode root = new TreeNode(val);
        root.left = recursive(s, depth+1);
        if (root.left == null) root.right = null;
        else root.right = recursive(s, depth+1);
        return root;
    }

}
