package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个可能含有重复值的数组 arr，
 * 找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。
 *
 * @author zhuqiu
 * @date 2020/3/25
 */
public class MonotonicStack {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);
        int len = 0;
        int[] arr = null;
        try {
            len = Integer.valueOf(in.readLine());
            arr = new int[len];
            String[] split = in.readLine().split("\\s");
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//            for (int i = 0; i < len; i++) {
//                arr[i] = Integer.parseInt(String.valueOf(in.read()));
//            }

        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, -1);
        Arrays.fill(left, -1);
        method(len, left, right, arr);
        for (int i = 0; i < len; i++) {
            System.out.printf("%d %d\n", left[i], right[i]);
        }
    }

    public static void method(int len, int[] left, int[] right, int[] arr) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                right[stack.pop()] = i;
            }
            int top = stack.isEmpty() ? -1 : stack.peek();
            if (stack.isEmpty()) {
            } else if (arr[stack.peek()] != arr[i]) {
                left[i] = top;
            } else {
                left[i] = left[top];
            }
            stack.push(i);
        }
    }
}
