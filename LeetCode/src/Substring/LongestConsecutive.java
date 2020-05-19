package Substring;

import java.util.HashSet;

/**
 * @author zhuqiu
 * @date 2020/4/10
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int max = new LongestConsecutive().longestConsecutive(nums);
        System.out.println(max);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashSet set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        int longestLen = 0;
        for (int num : nums) {
            if (!set.contains(num-1)){    // 减少查找次数
                int currentNum = num;
                int currentLen = 1;
                while (set.contains(currentNum+1)){   // 向上查找
                    currentNum++;
                    currentLen++;
                }
                longestLen = Math.max(longestLen, currentLen);
            }

        }
        return longestLen;
    }
}
