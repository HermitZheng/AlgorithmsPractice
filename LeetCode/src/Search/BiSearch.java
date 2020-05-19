package Search;

/**
 * @author zhuqiu
 * @date 2020/4/11
 */
public class BiSearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int res = new BiSearch().searchInsert(arr, 3);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {  // 有几个主要的注意点
        if (nums == null || nums.length == 0 || target == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0, right = len;                  // 1.如果target大于所有数，则数组的下一个数是我们所找的，也就是len

        while (left < right) {                      // 2.区别于left<=right的三分做法；left+1<right可能减少循环次数，即在left和right中间夹着一个数，需要分别判断left和right是不是target
//            int mid = left + (right - left) / 2;    // 3.如果要向上取整则是right-left+1，但是向上取整和下面一条只能存在一个
            int mid = (left + right) >>> 1;         //   也可以使用 mid = (left + right) >>> 1 无符号右移，好处是避免整形溢出
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;                     // 4.和向上取整不能同时存在
            } else {
                return mid;
            }
//            System.out.println(left + mid + right);
        }
        return left;
    }

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target == 0) {  // 模板
            return 0;
        }
        int len = nums.length;
        int left = 0, right = len;

        while (left < right) {
//            int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;         //   也可以使用 mid = (left + right) >>> 1 无符号右移，好处是避免整形溢出
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
