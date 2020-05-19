package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuqiu
 * @date 2020/4/17
 */
public class JumpToEnd {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean b = new JumpToEnd().canJump_3(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] reach = new boolean[len];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer pos = queue.poll();
                if (reach[pos] == true) continue;
                reach[pos] = true;
                int jump = nums[pos];
                for (int j = 0; j < jump; j++) {
                    if (pos + j + 1 < len && reach[pos + j + 1] == false) queue.offer(pos + j + 1);
                }
            }
        }
        if (reach[len - 1] == true) return true;
        else return false;
    }

    boolean[] reach;

    public boolean canJump_2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums == null || nums.length == 0 || nums[0] == 0) {
            return false;
        }
        int len = nums.length;
        reach = new boolean[len];
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums, int pos) {
        if (nums[pos] == 0 || reach[pos] == true) return false;

        int len = nums.length;
        if (pos + 1 >= len) return true;

        int jump = nums[pos];
        if (jump + pos + 1 >= len) return true;

        for (int i = 1; i <= jump; i++) {
            if (dfs(nums, pos + i)) return true;
            reach[pos] = true;
        }
        return false;
    }

    public boolean canJump_3(int[] nums) {
        int distance = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= distance) {
                distance = 1;
            } else {
                distance++;
            }
            if (i == 0 && distance > 1) {
                return false;
            }
        }
        return true;
    }
}
