package Futu.spring;

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

    public void sort(int[] nums) {

        int len = nums.length;
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < len; i++) {
            // index以左的数都已经有序，因此从index开始就行
            i = index > i ? index : i;
            for (int j = len - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    // 说明这一轮有交换，需要继续检查
                    flag = true;
                    // 记录这一轮进行交换的最左边这个位置
                    // （index以左的数都已经有序，因为已经不需要交换了）
                    index = j - 1;
                }
            }
            // 如果有一轮没有进行交换，那就说明已经有序，退出
            if (!flag) {
                return;
            }
        }
    }
}

