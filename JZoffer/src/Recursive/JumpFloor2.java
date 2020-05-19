package Recursive;

import java.util.Arrays;

public class JumpFloor2 {
    public static void main(String[] args) {
        long result = jump(40);
//        long result2 = Solution(40);
        System.out.println(result);
//        System.out.println(result2);
    }

    public static long jump(int target){
        /**
         * 设置一个数组即可，在求的过程中把值都暂时放在数组里，
         * 最后求的时候遍历数据这些求好的对应的阶级种数之和即为新的下级阶梯种数
         */
        if (target <= 2){
            return target;
        }
        long[] floor = new long[target + 1];
        Arrays.fill(floor, 1);
        floor[0] = 0;
        for (int i = 2; i < target + 1; i++) {
            for (int j = 0; j < i; j++) {
                floor[i] += floor[j];
            }
        }
        long result = floor[target];
        return result;
    }

//    public static long Solution(int target) {
    /**
     * f(n)=f(n-1)+f(n-2)+...+f(1)
     * f(n-1)=f(n-2)+...f(1)
     * 得:f(n)=2*f(n-1)
     *
     * f(1) = 1
     * f(n) = pow(2, n - 1)
     */
//        return 1 << (target-1);
//        //return (int)Math.pow(2,target-1);
//    }
}
