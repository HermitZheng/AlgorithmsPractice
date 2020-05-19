package Array;

/**
 * @author zhuqiu
 * @date 2020/4/25
 */
public class IntervalCount {

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        int lower = -2, upper = 2;
        int res = new IntervalCount().countRangeSum(nums, lower, upper);
        System.out.println(res);
    }

    int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        mergeSort(nums, 0, nums.length-1, lower, upper);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right, int lower, int upper) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, lower, upper);
        mergeSort(nums, mid + 1, right, lower, upper);
        if (nums[mid] <= nums[mid+1]) return;
        merge(nums, left, mid+1, right, lower, upper);
    }

    public void merge(int[] nums, int left, int mid, int right, int lower, int upper) {
        int[] leftArray = new int[mid-left];
        int leftSum = 0;
        for (int i = left; i < mid; i++) {
            leftArray[i-left] = nums[i];
            leftSum += nums[i];
        }
        if (leftSum >= lower && leftSum <= upper) {
            count++;
        }

        int[] rightArray = new int[right-mid+1];
        int rightSum = 0;
        for (int i = mid; i <= right; i++) {
            rightArray[i-mid] = nums[i];
            rightSum += nums[i];
        }
        if (rightSum >= lower && rightSum <= upper) {
            count++;
        }

        int low_bound=mid+1;
        int up_bound=mid+1;

        for(int i=left;i<=mid;i++){ // 计数
            while(low_bound<=right&&nums[low_bound]-nums[i]<lower) // 退出while后 low_bound是在右边数组中第一个使得pre_sum[low_bound] - pre_sum[i] >= lower的位置
                low_bound++;
            while(up_bound<=right&&nums[up_bound]-nums[i]<=upper) // up_bound是在右边数组中第一个使得pre_sum[up_bound] - pre_sum[i] >upper的位置
                up_bound++;

            count+=(up_bound-low_bound);
        }

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] > rightArray[j]) {
                nums[k++] = rightArray[j++];
            } else {
                nums[k++] = leftArray[i++];
            }
        }

        while (i < leftArray.length) {
            nums[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            nums[k++] = rightArray[j++];
        }
    }
}
