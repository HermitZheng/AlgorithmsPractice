package Array;

/**
 * 11. 盛最多水的容器
 *
 * @author zhuqiu
 * @date 2020/4/18
 */
public class maxArea {

    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        int max = new maxArea().maxArea(height);
        System.out.println(max);
    }

    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int len = height.length;
        int left = 0, right = len - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * Math.abs(left - right));
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
