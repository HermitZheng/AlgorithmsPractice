import map.myHashMap;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/3/14
 */
public class GradePercentage {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] gradeList = new int[num];
        for (int i = 0; i < num; i++) {
            gradeList[i] = scan.nextInt();
        }
        int qNum = scan.nextInt();
        int[] query = new int[qNum];
        for (int i = 0; i < qNum; i++) {
            query[i] = scan.nextInt();
        }
        scan.close();

        GradePercentage method = new GradePercentage();
        double[] percentage = method.getPercentage(num, gradeList, qNum, query);
        for (int i = 0; i < percentage.length; i++) {
            System.out.printf("%.6f\n", percentage[i]);
        }
    }

    public double[] getPercentage(int num, int[] gradeList, int qNum, int[] query) {
        HashMap<Integer, Integer> gradeMap = new HashMap<>();
        for (int i = 0; i < gradeList.length; i++) {
            gradeMap.put(i, gradeList[i]);
        }
        ArrayList keyList = new ArrayList(sortByValue(gradeMap).keySet());
        double[] result = new double[qNum];
        for (int i = 0; i < qNum; i++) {
            int index = keyList.indexOf(query[i]);
            result[i] = Math.round((100000*(double)index / 100000*(double)num) * 100);
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> sortMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(kvEntry -> sortMap.put(kvEntry.getKey(), kvEntry.getValue()));

        return sortMap;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[i] <= base && i > j) {
                i++;
            }
            while (arr[j] > base && i > j) {
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        } // i和j相遇
        arr[left] = arr[i];
        arr[i] = base;

        quickSort(arr, left, i-1);
        quickSort(arr, i+1, right);
    }
}
