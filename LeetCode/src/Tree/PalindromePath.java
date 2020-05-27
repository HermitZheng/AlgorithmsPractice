package Tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuqiu
 * @date 2020/5/24
 */
public class PalindromePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(2);
        int i = new PalindromePath().pseudoPalindromicPaths(root);
        System.out.println(i);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        List<String> list = binaryTreePaths(root);
        int res = 0;
        for (String s : list) {
            System.out.println(s);
            if (isPalindromic(s)) res++;
        }
        return res;
    }

    public boolean isPalindromic (String path) {
        char[] chars = path.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        AtomicInteger count = new AtomicInteger();
        map.forEach((c, i) -> {
            if (i % 2 != 0) count.getAndIncrement();
        });
        if (count.get() >= 2) return false;
        else return true;
    }

    List<String> result = new ArrayList<>();

    private void dfs(TreeNode node, String pStr)
    {
        String newStr = pStr;
        if(null != node)
        {
            newStr += (pStr.equals("") ? node.val : "" + node.val );
            if( null == node.left && null == node.right) result.add(newStr);
            if( null != node.left) dfs(node.left, newStr);
            if( null != node.right) dfs(node.right, newStr);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return result;
    }
}
