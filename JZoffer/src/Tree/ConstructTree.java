package Tree;

import static Tree.TreeNode.midOrder;
import static Tree.TreeNode.preOrder;

/**
 * @author zhuqiu
 * @date 2020/3/22
 */
public class ConstructTree {

    public static void main(String[] args) {
        String s = "-1(3(2)(5))(4(6))";
        ConstructTree instance = new ConstructTree();
        TreeNode tree = instance.construct(s);
        midOrder(tree);
    }

    public TreeNode construct(String s) {
        if (s == null){
            return null;
        }
        if (!s.contains("(")){
            return new TreeNode(Integer.valueOf(s));
        }
        int sign=0;
        TreeNode root = null;
        outer:
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                root = new TreeNode(Integer.valueOf(s.substring(0, i)));

                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        sign++;
                    } else if (s.charAt(j) == ')'){
                        sign--;
                    }
                    if (sign==0){
                        root.left = construct(s.substring(i+1, j));
                        if (j == s.length()-1){
                            break outer;
                        }
                        root.right = construct(s.substring(j+2, s.length()-1));
                        break outer;
                    }
                }

            }
        }
        return root;
    }
}
