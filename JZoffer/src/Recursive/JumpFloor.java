package Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JumpFloor {

    public static void main(String[] args) {
        int floor = 40;
        int result = jump(40);
        int result2 = loop(40);
        System.out.println(result);
        System.out.println(result2);
        System.out.println((5 >> 2) >>> 2);
    }

    public static int jump(int floor){
        /**
         *  f(n) = f(n-1) + f(n-2)
         *  例如：f(5) = f(3) + f(4)
         */
        if (floor == 1){
            return 1;
        }else if (floor ==2){
            return 2;
        }

        return jump(floor - 1) + jump(floor - 2);
    }

    public static int loop(int floor){
        /**
         * @first：代表距离下一级差一级的台阶。 == 跳到这一级的方案数
         * @second：代表距离下一级差两级的台阶。 == 跳到这一级的方案数
         * @target：代表目标台阶。 == first + second
         *
         * 例如： 跳到第五级可以考虑从第三级或者第四级跳上来，
         * 这时second、first、target代表3、4、5级
         * 方案数first=5， second=3， target=3+5=8
         */
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
