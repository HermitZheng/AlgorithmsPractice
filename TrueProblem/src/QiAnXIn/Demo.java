package QiAnXIn;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/9/2
 */
public class Demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int res = jump(n);

        System.out.println(res);
    }

    public static int jump(int floor) {
        int first = 2;
        int second = 1;
        int target = 0;
        if (floor == 1){
            return 1;
        }else if(floor == 2){
            return 2;
        }
        for (int i = 3; i <= floor; i++) {
            target = first + second;
            second = first;
            first = target;
        }

        return target;
    }
}
