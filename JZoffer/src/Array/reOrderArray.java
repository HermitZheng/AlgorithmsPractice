package Array;

/**
 * @author zhuqiu
 * @date 2020/3/10
 */
public class reOrderArray {

    public void reOrderArray(int [] array) {

        int len = array.length;
        int[] sign = {};
        for (int i = 0; i < len; i++) {
            if (array[i]%2 == 0){

                int temp = array[i];
                for (int j = i+1; j < array.length; j++) {
                    array[j-1] = array[j];
                }
                array[array.length-1] = temp;
                i -= 1;
                len -= 1;

            }
        }
    }

    public static void main(String[] args) {
        int [] array1 = {2, 4, 6, 1, 3, 5, 7};
        int [] array2 = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray order = new reOrderArray();
        order.reOrderArray(array2);
        for (int i : array2) {
            System.out.println(i);
        }
    }
}
