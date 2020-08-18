package Tree;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/7/30
 */
public class Serialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null,");
                    continue;
                }
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val + ",");
            }
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
//        int[] list = Arrays.stream(data.split(",")).mapToInt(Integer::valueOf).toArray();
        String[] list = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(list[index++]));
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (!list[index].equals("null")) {
                    TreeNode left = new TreeNode(Integer.valueOf(list[index]));
                    node.left = left;
                    queue.offer(left);
                }
                index++;
                if (!list[index].equals("null")) {
                    TreeNode right = new TreeNode(Integer.valueOf(list[index]));
                    node.right = right;
                    queue.offer(right);
                }
                index++;
            }
        }
        return root;
    }
}
