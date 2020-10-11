package Sort;

/**
 * @author Hanabi
 */
public class BubbleSort {

    public static void main(String[] args) {
        int size = 20;
        int[] arr = MyRandom.genRandom(size);
//        int[] arr = {12, 54, 87, 63, 95, 19, 44, 52, 36 ,74 ,22 ,36 ,21 ,55 ,69 ,87 ,50};
        int len = arr.length;
        int temp = 0;

        for (int i = 0; i < len; i++) {
            for (int j = len-1; j > i ; j--) {
                if (arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}
