package map;

import Sort.MyRandom;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/3/16
 */
public class myHashMap {

    public static void main(String[] args) {
        HashMap<Integer, Integer> gradeMap = new HashMap<>();
        int[] gradeList = MyRandom.genRandom(20);
        for (int i = 0; i < gradeList.length; i++) {
            gradeMap.put(i, gradeList[i]);
        }
//        gradeMap.forEach((key, value) -> System.out.println(value));
        Map<Integer, Integer> sortMap = sortByValue(gradeMap);
        sortMap.forEach((key, value) -> System.out.printf("{id: %d, grade: %d}\n", key, value));

    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map){
        Map<K, V> sortMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(kvEntry -> sortMap.put(kvEntry.getKey(), kvEntry.getValue()));
        return sortMap;
    }

}
