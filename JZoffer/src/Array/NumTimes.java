package Array;

/**
 * @author zhuqiu
 * @date 2020/4/3
 */
public class NumTimes {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4, 5};
        NumTimes instance = new NumTimes();
        int num = instance.GetNumberOfK(array, 3);
        System.out.println(num);
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = BiSearch(array, k-0.5);
        int after = BiSearch(array, k + 0.5);
        int result = after - begin;
        return result;
    }

    public int BiSearch(int[] array, double num) {
        int len = array.length - 1;

        int begin = 0;
        while (begin <= len) {
            int mid = (len + begin) / 2;
            if (num > array[mid]) {
                begin = mid + 1;
            } else if (num <= array[mid]) {
                len = mid - 1;
            }
        }
        return begin;
    }
}
