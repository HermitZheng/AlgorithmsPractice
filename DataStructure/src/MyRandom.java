import java.util.Random;

public class MyRandom {

    public static void main(String[] args) {
        int size = 20;
        int[] arr = genRandom(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int[] genRandom(int size){
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
