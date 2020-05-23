package Tree;

/**
 * leetcode 04.02
 *
 * @author zhuqiu
 * @date 2020/5/19
 */
public class minDepth {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums.length == 0) return root;
        return construct(nums, 0, nums.length-1);
    }

    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int mid = left + (right - left) / 2;            // 二分找到根结点，二分两边的子序列为左右子树
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, left, mid-1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }
}
