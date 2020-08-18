package Design;

import Tree.TreeNode;

import java.util.*;

/**
 * leetcode 297
 *
 * @author zhuqiu
 * @date 2020/6/16
 */
public class SerializeTree {

    public static void main(String[] args) {
        SerializeTree code = new SerializeTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        String serialize = code.serialize(root);
        String serialize_ = code.serialize_(root);
        System.out.println(serialize);
        System.out.println(serialize_);
        TreeNode node = code.deserialize(serialize);
        System.out.println(node.val);
        System.out.println(node.left.val);
        System.out.println(node.right.val);
        System.out.println(node.left.right.val);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {      //用StringBuilder
        StringBuilder res = ser_help(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder ser_help(TreeNode root, StringBuilder str){
        if(null == root){
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = ser_help(root.left, str);
        str = ser_help(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] split = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return build(list);
    }

    private TreeNode build(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = build(list);
        root.right = build(list);
        return root;
    }

//    以下是层序遍历，超内存，待优化

    public String serialize_(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int flag = 0;

        while (!deque.isEmpty()) {
            StringBuilder deck = new StringBuilder();
            int size = deque.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll == null) {
                    count++;
                    deck.append("null" + ",");
                    deque.offer(null);
                    deque.offer(null);
                } else {
                    deck.append(poll.val + ",");
                    deque.offer(poll.left);
                    deque.offer(poll.right);
                }
            }
            if (Math.pow(2, flag) == count) break;
            else sb.append(deck);
            flag++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize_(String data) {
        if (data == null || data.length() == 0) return null;
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        if (split.length >= 2) root.left = build(split, 1);
        if (split.length >= 3) root.right = build(split, 2);
        return root;
    }

    private TreeNode build(String[] split, int index) {
        if(index >= split.length || split[index].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(split[index]));
        if (2 * index > split.length) return root;
        root.left = build(split, 2 * index + 1);
        root.right = build(split, 2 * index + 2);
        return root;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
