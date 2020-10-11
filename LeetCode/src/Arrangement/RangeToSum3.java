package Arrangement;

import java.util.*;

/**
 * leetcode 216
 *
 * @author zhuqiu
 * @date 2020/9/9
 */
public class RangeToSum3 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> list = new ArrayList<>();

        dfs(1, k, n, list);
        return res;
    }

    private void dfs(int begin, int k, int target, List<Integer> list) {
        if (list.size() == k) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i=begin; i<=9; i++) {
            if (i > target) {
                break;
            }
            list.add(i);
            dfs(i+1, k, target-i, list);
            list.remove(list.size()-1);
        }
    }
}

/**
 * leetcode 377
 */
class RanggeToSum_4 {

    
}
