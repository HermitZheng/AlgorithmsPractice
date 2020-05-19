package Futu;

/**
 * @author zhuqiu
 * @date 2020/5/12
 */
public class Bubble {

    public static void main(String[] args) {

        int[] nums = {9, 5, 3, 4, 8};
        new Bubble().sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void sort(int[] nums ){

        int len = nums.length;
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < len; i++) {
            i = index > i ? index : i;
            for (int j = len-1; j > i; j--) {
                if (nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                    index = j-1;
                }
            }
            if (!flag) return;
        }
    }
}

