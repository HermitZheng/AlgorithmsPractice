package String;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/5/17
 */
public class ArrangeWords {

    public static void main(String[] args) {
        String res = new ArrangeWords().arrangeWords("To be or not to be");
        System.out.println(res);
    }

    public String arrangeWords(String text) {
        String[] textList = text.split(" ");
        Map<Map<String, Integer>, Integer> map = new LinkedHashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < textList.length; i++) {
            String word = textList[i];
            if (i == 0) {
                word = (char) (word.charAt(0) + 32) + word.substring(1);
            }
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            Map<String, Integer> item = new HashMap<>();
            item.put(word, countMap.get(word));
            map.put(item, word.length());
        }
        List<Map.Entry<Map<String, Integer>, Integer>> lenList = new ArrayList<>(map.entrySet());
        Collections.sort(lenList, Comparator.comparingInt(Map.Entry::getValue));

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (Map.Entry<Map<String, Integer>, Integer> entry : lenList) {
            for (Map.Entry<String, Integer> item : entry.getKey().entrySet()) {
                String word = item.getKey();
                if (!flag) {
                    String temp = (char)(word.charAt(0) - 32) + word.substring(1);
                    sb.append(temp);
                    flag = true;
                    continue;
                } else sb.append(" ");
                sb.append(word);
            }
        }
        return sb.toString();
//        for (Map.Entry<String, Integer> entry : lenList) {
//            String word = entry.getKey();
//            if (!flag) {
//                countMap.put(word, countMap.get(word)-1);
//                String temp = (char)(word.charAt(0) - 32) + word.substring(1);
//                sb.append(temp);
//                flag = true;
//            }
//            while (countMap.get(word) > 0) {
//                sb.append(" ");
//                sb.append(word);
//                countMap.put(word, countMap.get(word)-1);
//            }
//        }

//        for (Map.Entry<String, Integer> stringIntegerEntry : lenList) {
//            System.out.println(stringIntegerEntry.getKey() + stringIntegerEntry.getValue());
//        }
    }
}
