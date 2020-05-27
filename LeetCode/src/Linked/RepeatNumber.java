package Linked;

/**
 * leetcode 287
 *
 * @author zhuqiu
 * @date 2020/5/26
 */
public class RepeatNumber {

    public int findDuplicate(int[] nums) {

        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
