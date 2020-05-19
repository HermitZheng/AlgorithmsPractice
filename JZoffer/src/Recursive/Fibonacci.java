package Recursive;

public class Fibonacci {
    public static void main(String[] args) {
        int count = 39;
        int result = recursion(39 - 1);
        int result2 = loop(39);
        System.out.println(result);
        System.out.println(result2);
    }

    public static int recursion(int count){
        if (count == 0 || count == 1){
            return 1;
        }
        return recursion(count - 1) + recursion(count - 2);
    }

    public static int loop(int count){
        int left = 0;
        int right = 0;
        for (int i = 0; i < count; i++) {
            if (i == 0){
                right += 1;
            } else if (i == 1) {
                left += 1;
            }else {
//                int temp = right;
                right += left;
                left = right - left;
            }
        }
        return right;
    }
}
