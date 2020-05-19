package Array;

import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/3/10
 */
public class RotateArray {

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int len = array.length;
        int min = array[len-1];
        for (int i = len-1; i >=0 ; i--) {
            if (array[i] <= min){
                min = array[i];
                stack.push(min);
                continue;
            }
//            System.out.println(i);
            min = stack.pop();
//            System.out.println("最小值是：" + min);
            break;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        array[0] = 3;
        array[1] = 4;
        array[2] = 5;
        array[3] = 1;
        array[4] = 2;
        RotateArray rotateArray = new RotateArray();
        int result = rotateArray.minNumberInRotateArray(array);
        System.out.println("结果为：" + result);
    }
}
