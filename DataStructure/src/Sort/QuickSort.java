package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int size = 20;
        int[] arr1 = MyRandom.genRandom(size);
        int[] arr = {45, 80, 55, 40, 42, 85};

        quickSort(arr1, 0, arr1.length - 1);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 左边索引大于右边，不合法
        // 可用于作为下面递归的结束条件
        if (left > right) {
            return;
        }
        dealPivot(arr, left, right);
        int base = arr[right-1];
        int i = left;
        int j = right-1;

        while (j != i) {
            while (arr[j] > base && j > i) {
                j--;  // j从右往左移动
            }
            while (arr[i] < base && j > i) {
                i++;  // i从左往右移动
            }
            swap(arr, i, j);
        } // 循环结束则代表i与j索引相遇
        // 基准数base移动
        arr[right-1] = arr[i];
        arr[i] = base;
        // 基准数归位，左边的元素都比基准数小，右边元素都比基准数大

        // 排序基准数左边
        quickSort(arr, left, i - 1);
        // 排序基准数右边
        quickSort(arr, j + 1, right);
        return;
    }

    public static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        swap(arr, right-1, mid);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
