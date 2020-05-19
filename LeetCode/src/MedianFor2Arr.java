import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/8
 */
public class MedianFor2Arr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums1 = new int[len];
        int[] nums2 = new int[len];
        for (int i = 0; i < len; i++) {
            nums1[i] = in.nextInt();
        }
        for (int i = 0; i < len; i++) {
            nums2[i] = in.nextInt();
        }
        MedianFor2Arr instance = new MedianFor2Arr();
        instance.findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;    // 取(left+right)/2，当是奇数时取中间的中位数，当是偶数时取两个中位数的平均值

        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j+k-1];
        if (j >= nums2.length) return nums1[i+k-1];   // 当任意一个数组“空了”， 意味着中位数在另一个数组中
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midValue1 = (i + k/2 -1 < nums1.length) ? nums1[i + k/2 -1] : Integer.MAX_VALUE;
        int midValue2 = (j + k/2 -1 < nums2.length) ? nums2[j + k/2 -1] : Integer.MAX_VALUE;  // 找到数组剩余部分中的第k/2个数
        if (midValue1 < midValue2) {  // 二分查找
            return findKth(nums1, i + k/2, nums2, j, k - k/2);
        } else {
            return findKth(nums1, i, nums2, j + k/2, k - k/2);
        }
    }
}
