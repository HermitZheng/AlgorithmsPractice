package Sort;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        mergeSort(arrays, 0, arrays.length-1);
        for (int array : arrays) {
            System.out.println(array);
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        } else {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            if (array[mid] - (array[mid + 1]) <= 0) {
                return;
            }
            merge(array, left, mid + 1, right);
        }
        return;
    }

    public static void merge(int[] array, int left, int mid, int right) {

        int[] leftArray = new int[mid - left];
        for (int i = left; i < mid; i++) {
            leftArray[i-left] = array[i];
        }

        int[] rightArray = new int[right - mid + 1];
        for (int i = mid; i <= right; i++) {
            rightArray[i-mid] = array[i];
        }

        int k = left;
        int i = 0, j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
                k++;
            } else {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftArray.length){
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
        return;
    }
}
