package Array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/4/25
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        List<List<Integer>> permute = new Permutations().permute(nums);
        for (List<Integer> integers : permute) {
            System.out.println(integers.toString());
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || len == 0) return res;

        Deque<Integer> stack = new ArrayDeque<>();
        boolean used[] = new boolean[len];
        dfs(nums, len, 0, stack, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> stack, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            stack.push(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, stack, used, res);
            stack.pop();
            used[i] = false;
        }
    }
}
