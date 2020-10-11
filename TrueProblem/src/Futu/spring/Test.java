package Futu.spring;

/**
 * @author zhuqiu
 * @date 2020/5/12
 */
public class Test {

    public static void main(String[] args) {

//        int[] nums = {3, 5, 7, 9, 6, 4, 1, 8};
        int[] nums = {5,1,1,2,0,0};
        new Test().quickSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void quickSort(int[] nums, int left, int right) {
        int pivot;
        if (left < right) {
            pivot = partition(nums, left, right);
            quickSort(nums, left, pivot-1);
            quickSort(nums, pivot+1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = choosePivot(nums, left, right);
        if (!(pivot == left)) {
            nums[pivot] += nums[left];
            nums[left] = nums[pivot] - nums[left];
            nums[pivot] -= nums[left];
        }
        pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int choosePivot(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if ((nums[left] - nums[mid]) * (nums[left] - nums[right]) <= 0) {
            return left;
        } else if ((nums[mid] - nums[left]) * (nums[mid] - nums[right]) <= 0) {
            return mid;
        } else {
            return right;
        }
    }
}
