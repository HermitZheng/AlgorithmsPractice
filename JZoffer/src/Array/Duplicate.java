package Array;

/**
 * @author zhuqiu
 * @date 2020/3/26
 */
public class Duplicate {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1, 4};
        int[] res = new int[1];
        duplicate(arr, arr.length, res);
    }

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        int[] help = new int[length];
        for (int i = 0; i < length; i++) {
            if (help[numbers[i]] == 1){
                duplication[0] = numbers[i];
                break;
            }
            help[numbers[i]] ++;
        }
        if (duplication[0] == -1) {
            return false;
        } else {
            System.out.println(duplication[0]);
            return true;
        }
    }
}
