import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *  按字典序对不等长数组（int）进行排序
 * @author zhuqiu
 * @date 2020/3/16
 */
public class Arrangement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
//        while (in.hasNextLine()) {
        str = in.nextLine();
//        }
        String[] split = str.split(",");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }

        ArrayList<String> sortList = sortList(list);
        String result = "";
        for (String s : sortList) {
            result += s;
        }
        System.out.println(result);
    }


    public static ArrayList<String> sortList(ArrayList<String> strings) {
        if (strings == null) {
            return null;
        }
//        Collections.sort(strings, (o1, o2) -> {
//            if (o1 == null || o2 == null) {
//                return 0;
//            }
//            int len = o1.length() <= o2.length() ? o1.length() : o2.length();
//            for (int i = 0; i < len; i++) {
//                String t1 = o1.substring(i, i+1);
//                String t2 = o2.substring(i, i+1);
//                if (o1.charAt(i) == o2.charAt(i)) {
//                    continue;
//                } else if (o1.charAt(i) > o2.charAt(i)) {
//                    return 1;
//                } else if (o1.charAt(i) < o2.charAt(i)) {
//                    return -1;
//                }
//            }
//            return -1;      //  如果较长的那个字符串前几位和较短的一样，那么判定较长的字符串更小
//        });

        strings.sort(String::compareTo);   // 使用这个compareTo时，会认定较短的那个字符串更小

        return strings;
    }
}
