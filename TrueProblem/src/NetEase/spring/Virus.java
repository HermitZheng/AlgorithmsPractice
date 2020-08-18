package NetEase.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class Virus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int city = in.nextInt();
        int party = in.nextInt();
        int id = in.nextInt();

        if (city == 0 || party == 0){
            System.out.println(0);
            return;
        }

        Set set = new HashSet();
        set.add(id);
        for (int i = 0; i < party; i++) {
            int num = in.nextInt();
            int flag = 0;
            ArrayList array = new ArrayList(num);
            for (int j = 0; j < num; j++) {
                int people = in.nextInt();
                array.add(people);
                if (set.contains(people)){
                    flag = 1;
                }
            }
            if (flag == 1){
                set.addAll(array);
            }
            if (set.size() >= city) {
                System.out.println(city);
                return;
            }
        }
        System.out.println(set.size());
    }
}
