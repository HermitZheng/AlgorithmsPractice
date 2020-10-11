package Arrangement;

import java.util.*;

/**
 * leetcode 39
 *
 * @author zhuqiu
 * @date 2020/9/9
 */
public class RangeToSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i=0; i<candidates.length; i++) {
            dfs(candidates, i, sum, target, list);
        }

        return res;
    }

    private void dfs(int[] candidates, int i, int sum, int target, List<Integer> list) {
        if (sum + candidates[i] > target) {
            return;
        }
        if (sum + candidates[i] == target) {
            list.add(candidates[i]);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(candidates[i]);
        sum += candidates[i];
        for (int k=i; k<candidates.length; k++) {
            dfs(candidates, k, sum, target, list);
        }
        list.remove(list.size()-1);
        sum -= candidates[i];
    }
}

/**
 * leetcode 40
 */
class RangeToSum_2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, 0, target, list);

        return res;
    }

    private void dfs(int[] candidates, int begin, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=begin; i<candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, i+1, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}
