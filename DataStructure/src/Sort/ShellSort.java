package Sort;

/**
 * @author zhuqiu
 * @date 2020/3/19
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {3, 5, 8, 4, 2, 6, 1, 0, 1};
        int[] sort = sort(array);
        for (int i : sort) {
            System.out.println(i);
        }

    }

    public static int[] sort(int[] array) {

        int len = array.length;
        for (int gap = len/2; gap >0 ; gap/=2) {        // 增量从1/2长度开始，每一轮缩短一半

            for (int i = gap; i < len; i++) {           // 每一个组内各自进行插排
                int j = i;                              // j为array的后半部分
                while (j-gap>=0 && array[j] < array[j-gap]) {  //  当组内的后半部分比前半部分小，则交换
                    swap(array, j, j-gap);
                    j -= gap;                           // 当一个组内有>2个元素时起作用
                }
            }
        }

        return array;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
