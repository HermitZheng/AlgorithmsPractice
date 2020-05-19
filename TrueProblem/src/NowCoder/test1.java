package NowCoder;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/3/19
 */
public class test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s2 : s1) {
            list.add(Integer.parseInt(s2));
        }
        list.sort(Comparator.comparing(Integer::intValue));
        int len = list.size();

        String result = list.get(0).toString() + " ";
        for (int i = 1; i < len; i++) {
            result = result.concat(list.get(i).toString()+" ");
            if (i + 1 == len){
                break;
            }
            i++;
            String temp = list.get(i).toString() + " ";
            result = temp.concat(result);
        }
        String[] strings = result.split(" ");
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Integer.parseInt(strings[i]);
        }
        int max = Math.abs(res[0] - res[1]);
        for (int i = 0; i < len-1; i++) {
            int n = Math.abs(res[i] - res[i+1]);
            if (n > max) {
                max = n;
            }
        }
        int abs = Math.abs(res[0] - res[len - 1]);
        if (abs > max){
            max = abs;
        }
        System.out.println(max);
    }

}
