package QiNiu;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/28
 */
public class Consumers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            method(s);
        }
    }

    public static void method(String s) {
        String[] split = s.split("");
        int len = split.length;
        ArrayList<String> res = new ArrayList<>(len);
        res.addAll(Arrays.asList(split));
        boolean flag = false;
        Stack<Integer> stack = new Stack<>();
        do {
            flag = false;
            len = split.length;
            for (int i = 1, j=0; i < len; i++, j++) {
                if (split[i].equals(split[j])) {
                    flag = true;
                    stack.push(i);
                    i++;
                    j++;
                }
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                res.remove((int)pop);
                res.remove(pop-1);
            }
            if (!res.isEmpty()) {
                split = res.toArray(new String[0]);
            } else {
                break;
            }
        } while (flag == true);
        if (res.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
