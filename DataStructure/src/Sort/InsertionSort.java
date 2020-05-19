package Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int size = 20;
        int[] sortArr = MyRandom.genRandom(size);
//        int[] sortArr = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < size; i++) {
            int temp = sortArr[i];
            int j = i;
            while (j > 0 && temp < sortArr[j-1]){
                sortArr[j] = sortArr[j-1];
                j--;
            }
//            sortArr[j] = temp;
            if (j != i){
                sortArr[j] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(sortArr[i]);
        }
    }
}
