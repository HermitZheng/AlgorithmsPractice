import Sort.MyRandom;

/**
 * @author zhuqiu
 * @date 2020/8/17
 */
public class PlayGround {

    public static void main(String[] args) {
        int size = 20;
        int[] arr = MyRandom.genRandom(size);
        int[] arr1 = {45, 80, 55, 40, 42, 85};

        new PlayGround().quickSort(arr1, 0, arr1.length - 1);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }


    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int base = arr[left];
        int i = left, j = right;

        while (i != j) {
            while (arr[i] <= base && j > i) {
                i++;
            }
            while (arr[j] >= base && j > i) {
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;

        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);
    }
}
