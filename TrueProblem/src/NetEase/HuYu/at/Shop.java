package NetEase.HuYu.at;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/9/5
 */
public class Shop {

    static int[] value;
    static Map<Integer, Stack<Integer>> map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        value = new int[N];
        map = new HashMap<>(N + 1);

        for (int i = 0; i < N; i++) {
            value[i] = in.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int count = in.nextInt();
            in.nextLine();

            String[] list = new String[count];
            for (int j = 0; j < count; j++) {
                list[j] = in.nextLine();
            }
            int sum = method(list);

            System.out.println(sum);
        }
    }

    private static int method(String[] list) {
        int sum = 0;
        int left = 0, right = 0;
        for (String ss : list) {
            String[] s = ss.split(" ");
            String hand = s[0], act = s[1];
            int channel = -1;
            if (!act.equals("keep")) {
                channel = Integer.parseInt(s[2]);
            }

            if (act.equals("take")) {
                if (!map.containsKey(channel)) {
                    if (hand.equals("left")) {
                        left = value[channel - 1];
                    } else {
                        right = value[channel - 1];
                    }
                } else {
                    Stack<Integer> stack = map.get(channel);
                    int v = stack.isEmpty() ? value[channel - 1] : stack.pop();
                    if (hand.equals("left")) {
                        left = v;
                    } else {
                        right = v;
                    }
                }
                continue;
            }

            if (act.equals("return")) {
                Stack stack;
                if (!map.containsKey(channel)) {
                    stack = new Stack<>();
                } else {
                    stack = map.get(channel);
                }

                if (hand.equals("left")) {
                    stack.push(left);
                    left = 0;
                } else {
                    stack.push(right);
                    right = 0;
                }
                map.put(channel, stack);
            }

            if (act.equals("keep")) {
                if (hand.equals("left")) {
                    sum += left;
                    left = 0;
                } else {
                    sum += right;
                    right = 0;
                }
            }
        }
        return sum + left + right;
    }
}