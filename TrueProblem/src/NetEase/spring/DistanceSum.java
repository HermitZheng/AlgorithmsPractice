package NetEase.spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class DistanceSum {

    static long distance = 0;

    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
//        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
//        int[] arrays = new int[len];
//        for (int i = 0; i < len; i++) {
//            arrays[i] = in.nextInt();
//        }
        mergeSort(arrays, 0, arrays.length-1);
        for (int array : arrays) {
            System.out.println(array);
        }
        System.out.println("distance = " + distance);
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
        long sum_left = Arrays.stream(leftArray).sum();
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                sum_left -= leftArray[i];
                array[k] = leftArray[i];
                i++;
                k++;
            } else {
                distance += sum_left - (long)(leftArray.length-i)*rightArray[j];
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
