package Array;

import java.util.Arrays;

/**
 * leetcode 1300
 *
 * @author zhuqiu
 * @date 2020/6/14
 */
public class CloseToTarget {

    public static void main(String[] args) {
//        int[] arr = {1547, 83230, 57084, 93444, 70879};
        int[] arr = {1,2,23,24,34,36};
        int res = new CloseToTarget().findBestValue(arr, 110);
        System.out.println(res);
    }

    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        if (len == 0) return 0;

        Arrays.sort(arr);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum <= target) return arr[len - 1];


        for (int i = len - 1; i > 0; i--) {
            sum -= (len - i) * (arr[i] - arr[i - 1]);
            if (sum < target) {
//                int p = search(len, i, arr[i - 1], arr[i], arr[i + 1], target, sum);
                int p = biSearch(len, i, arr[i - 1], arr[i], target, sum);
                return p;
            }
        }
        if (Math.abs((target / len) * len - target) <= Math.abs((target / len + 1) * len - target)) {
            return target / len;
        } else {
            return target / len + 1;
        }
    }

    private int search(int len, int index, int left, int mid, int right, int target, int sum) {
        int dis = target - sum;
        int res = left;
        for (int i = left + 1; i <= right; i++) {
            if (left <= mid) {
                sum += len - index;
            } else {
                sum += len - index - 1;
            }
            if (Math.abs(target - sum) < dis) {
                dis = Math.abs(target - sum);
                res = i;
            } else {
                return res;
            }
        }
        return res;
    }

    private int biSearch(int len, int index, int left, int right, int target, int sum) {
        int dis = target - sum;
        int res = left;
        int flag = 1;
        while (left < right-1) {
//            int midNum = left + (right - left) / 2;
            int midNum = (left + right) >>> 1;
            sum += flag * ((len - index) * (midNum - left));
            if (sum == target) return left;
            if (sum > target) {
                if (sum - target < dis) {
                    dis = sum - target;
                    res = midNum;
                    right = midNum;
                } else right = midNum;
                flag = -1;
            } else if (sum < target) {
                if (target - sum < dis) {
                    dis = target - sum;
                    res = midNum;
                    left = midNum + 1;
                } else left = midNum;
                flag = 1;
            }
        }
        return res;
    }
}
