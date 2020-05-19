package Sort;

/**
 * @author Hanabi
 */
public class SelectionSort {
    public static void main(String[] args) {
        int size = 20;
        int[] arr = MyRandom.genRandom(size);

        for (int i = 0; i < size; i++) {
            int minindex = i;
            for (int j = i+1; j < size; j++) {
                if (arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex] = temp;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}
