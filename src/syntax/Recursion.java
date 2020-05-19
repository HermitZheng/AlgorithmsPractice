package syntax;

public class Recursion {
}
class rTest1 {
    /**
     *考察方法进栈与出栈的顺序
     */
    public static void main(String[] args) {
        split(12);
    }

    public static int split(int number) {
        /**
         * split（number）方法，最终返回的是number这个值，
         * 所以split（n）出栈的输出结果就是n
         */
        if (number > 1) {
            if (number % 2 != 0) {
                System.out.print(split((number + 1) / 2));
            }
            System.out.print(split(number / 2));
        }
        return number;
    }
}
