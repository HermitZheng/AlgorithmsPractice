package Search;

/**
 * leetcode 1095
 *
 * @author zhuqiu
 * @date 2020/4/29
 */

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);

    public int length();
}


class MountainArrayImpl implements MountainArray {
    private int[] arr;
    private int size;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
        this.size = this.arr.length;
    }

    @Override
    public int get(int index) {
        return this.arr[index];
    }

    @Override
    public int length() {
        return this.size;
    }

}

class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        MountainArray mountainArray = new MountainArrayImpl(arr);

        Solution solution = new Solution();
        int res = solution.findInMountainArray(target, mountainArray);
        System.out.println(res);
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int top_index = findTop(mountainArr, 0, len - 1);
        int asc = findFromASC(mountainArr, target, 0, top_index);
        int desc = findFromDESC(mountainArr, target, top_index + 1, len - 1);
        int res = Math.min(asc != -1 ? asc : len, desc != -1 ? desc : len);
        if (res == len) return -1;
        else return res;
    }

    public int findTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }   // 山顶一定存在（len>=3）
        return left;
    }

    public int findFromASC(MountainArray mountainArr, int target, int left, int right) {

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) return left;
        else return -1;

    }

    public int findFromDESC(MountainArray mountainArr, int target, int left, int right) {

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) return left;
        else return -1;

    }
}
