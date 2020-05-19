package DP;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 983
 *
 * @author zhuqiu
 * @date 2020/5/6
 */
public class LowestCost {

    int[] costs, days;
    Integer[] memo;
    int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        this.days = days;
        memo = new Integer[days.length];
        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] != null) return memo[i];
        memo[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k=0; k<3; k++) {
            while (j < days.length && days[j] < days[i] + durations[k]){
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }
        return memo[i];
    }
}

class OW {

    int[] costs;
    Set<Integer> set;
    Integer[] memo;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        set = new HashSet<>();
        for (int day: days) {
            set.add(day);
        }
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) return memo[i];
        if (set.contains(i)) {
            memo[i] = Math.min(Math.min(dp(i+1)+costs[0], dp(i+7)+costs[1]), dp(i+30)+costs[2]);
        } else {
            memo[i] = dp(i+1);
        }
        return memo[i];
    }
}
