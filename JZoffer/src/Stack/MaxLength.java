package Stack;

import Array.RotateArray;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/4/1
 */
public class MaxLength {
    public int method(int [] array) {
        if (array.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int len = array.length;
        int max = 0;
        for (int i = 0; i < len ; i++) {
            if (!stack.isEmpty() && array[i] <= stack.peek()){
                max = Math.max(max, stack.size());
                stack.clear();
            }
            stack.push(array[i]);
        }
        max = Math.max(max, stack.size());
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 9, 10, 2, 3, 6, 11, 9, 10};
        MaxLength instance = new MaxLength();
        int result = instance.method(array);
        System.out.println("结果为：" + result);
    }
}
