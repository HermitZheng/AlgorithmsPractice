package Tree;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/7/29
 */
public class PostOrder {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) {
            return true;
        }
        int root = postorder[postorder.length - 1];
        int i = 0;
        while (postorder[i] < root) {
            i++;
        }
        boolean left = verifyPostorder(Arrays.copyOfRange(postorder, 0, i));
        int rightFrom = i;
        while (i < postorder.length-1) {
            if (postorder[i] < root) {
                return false;
            }
            i++;
        }
        return left && verifyPostorder(Arrays.copyOfRange(postorder, rightFrom, i));
    }
}
