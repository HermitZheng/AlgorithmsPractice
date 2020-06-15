package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/6/12
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) return null;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {   // i 不能相同
                int right = len-1;      // 右指针
                int target = -nums[i];

                for (int left = i+1; left < right; left++) {
                    if (left > i+1 && nums[left] == nums[left-1]) continue; // 不使用重复的left
                    while (left < right && nums[left]+nums[right] > target) {   // nums从小到大排，如果太大，则让right左移
                        right--;
                    }
                    // left == right 则为无效，break
                    if (left == right) break;
                    if (nums[left] + nums[right] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}
