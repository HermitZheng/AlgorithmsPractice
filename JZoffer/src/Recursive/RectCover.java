package Recursive;

public class RectCover {
    /**
     * 用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 和“Recursive.JumpFloor”一样 ，只能选择一格或者两格mnmn
     *
     */
    public static void main(String[] args) {
        int result = 0;
        result = cover(20);
        System.out.println(result);
    }

//    public static int recursion(int len){
//        /**
//         * 递归
//         */
//    }

    public static int cover(int len){

        int a = 1, b = 2, c = 0;


        if (len == 1){
            return 1;
        }else if (len == 2){
            return 2;
        }
        for (int i = 3; i < len + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
