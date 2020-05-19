package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/3/19
 */
public class BucketSort {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] item = {1, 5, 20, 300, 14, 88, 955};
        Arrays.stream(item).forEach(value -> arr.add(value));

        sort(arr);

        arr.forEach(integer -> System.out.println(integer));

    }

    public static void sort(ArrayList<Integer> arr) {
        Integer min = (Integer) Collections.min(arr);
        Integer max = (Integer) Collections.max(arr);
        int size = max / 10 - min / 10 + 1;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();

        for (Integer item : arr) {
            int index = item / 10 - min / 10;
            ArrayList<Integer> list;
            try {
                list = bucket.get(index);
            }catch (IndexOutOfBoundsException e){
                list = null;
            }
            list.add(item);
            bucket.set(index, list);
        }
        arr.clear();
        for (ArrayList<Integer> list : bucket) {
            Collections.sort(list);
            arr.addAll(list);
        }
    }
}
