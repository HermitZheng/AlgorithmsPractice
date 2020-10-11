package Binary;

/**
 *
 * 5497. 查找大小为 M 的最新分组
 *
 * @author zhuqiu
 * @date 2020/8/23
 */
public class Group {

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int res = new Group().findLatestStep(arr, 1);
        System.out.println(res);
    }

    int max = -1;
    int size;

    public int findLatestStep(int[] arr, int m) {

        int k = arr.length-1;
        size = m;
        if (arr.length == m) {
            max = m;
        }
        group(arr, 0, k, k+1);
        return max == 0 ? 1 : max;
    }

    public void group(int[] arr, int i, int j, int divide) {
        if (divide <= 0 || i > j || max != -1) {
            return;
        }
        if (arr[divide-1] > j+1 || arr[divide-1] < i+1) {
            group(arr, i, j, divide-1);
            return;
        }

        int left = arr[divide-1] - i - 1;
        int right = j - arr[divide-1] + 1;

        if (left == size || right == size) {
            max = Math.max(max, divide);
            return;
        }

        group(arr, i, arr[divide]-2, divide-1);
        group(arr, arr[divide], j, divide-1);
    }
}
