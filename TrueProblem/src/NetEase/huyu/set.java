package NetEase.huyu;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/4/11
 */
public class set {

    static HashMap<Integer, Integer> hashMap;
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            N = in.nextInt();
            hashMap = new HashMap<>();
            int M = in.nextInt();
            for (int j = 0; j < M; j++) {
                int op = in.nextInt();
                int X = in.nextInt();
                if (op == 1) {
                    int Y = in.nextInt();
                    op_1(X, Y);
                } else if (op == 2) {
                    op_2(X);
                } else {
                    op_3(X);
                }
            }
        }
    }

    public static void op_1(int X, int Y) {
        if (!hashMap.containsKey(X) && !hashMap.containsKey(Y)){
            for (int i = 0; i < N; i++) {
                if (!hashMap.containsValue(i)){
                    hashMap.put(X, i);
                    hashMap.put(Y, i);
                }
            }
        } else if (!hashMap.containsKey(X)) {
            int y_num = hashMap.get(Y);
            hashMap.put(X, y_num);
        } else if (!hashMap.containsKey(Y)) {
            int x_num = hashMap.get(X);
            hashMap.put(Y, x_num);
        }

        int x_num = hashMap.get(X);
        int y_num = hashMap.get(Y);
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        if (x_num == y_num) {
            return;
        } else {
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() == y_num){
                    int key = entry.getKey();
                    hashMap.put(key, x_num);
                }
            }
        }
    }

    public static void op_2(int X) {
        Integer x_num = hashMap.get(X);
        for (int i = N; i >= 0 ; i--) {
            if (!hashMap.containsValue(i)){
                hashMap.put(X, i);
                return;
            }
        }
    }

    public static void op_3(int X) {
        if (hashMap.containsKey(X)) {
            int count = 0;
            Integer x_num = hashMap.get(X);
            Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() == x_num){
                    count++;
                }
            }
            System.out.println(count);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                if (!hashMap.containsValue(i)){
                    hashMap.put(X, i);
                    System.out.println(1);
                    return;
                }
            }
        }
    }
}
