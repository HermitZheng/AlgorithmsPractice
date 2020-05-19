package Basic;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author zhuqiu
 * @date 2020/5/4
 */
public class gradeRank_1004 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            int grade = Integer.parseInt(s[2]);
            map.put(grade, s[0] + " " + s[1]);
        }
        String[] stu = map.lastEntry().getValue().split(" ");
        System.out.println(stu[0] + " " + stu[1]);
        stu = map.firstEntry().getValue().split(" ");
        System.out.println(stu[0] + " " + stu[1]);
    }
}
