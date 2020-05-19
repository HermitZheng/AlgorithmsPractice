package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int size = 20;
        int[] arr = MyRandom.genRandom(size);
        int[] arr1 = {45, 80, 55, 40, 42, 85};

        quickSort(arr1, 0, arr1.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 左边索引大于右边，不合法
        // 可用于作为下面递归的结束条件
        if (left > right) {
            return;
        }
        int base = arr[left];
        int i = left;
        int j = right;

        while (j != i) {
            while (arr[j] >= base && j > i) {
                j--;  // j从右往左移动
            }
            while (arr[i] <= base && j > i) {
                i++;  // i从左往右移动
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        } // 循环结束则代表i与j索引相遇
        // 基准数base移动
        arr[left] = arr[i];
        arr[i] = base;
        // 基准数归位，左边的元素都比基准数小，右边元素都比基准数大

        // 排序基准数左边
        quickSort(arr, left, i - 1);

        // 排序基准数右边
        quickSort(arr, j + 1, right);
        return;
    }
}
