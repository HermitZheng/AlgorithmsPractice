package DP;

/**
 * @author zhuqiu
 * @date 2020/3/30
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci instance = new Fibonacci();
        System.out.println(instance.fib_for(39));
        System.out.println(instance.fibonacci(39));
    }

    public int fib_for(int n) {
        if (n <= 0) {
            return n;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre1 = 1;
        int pre2 = 1;
        int current = pre1 + pre2;
        for (int i = 3; i < n+1; i++) {
            current = pre1 + pre2;
            pre2 = pre1;
            pre1 = current;
        }
        return current;

    }

    public int fibonacci(int n) {

        if (n <= 0) {
            return 0;
        }
        int[] mem = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            mem[i] = -1;
        }
        return fib(n, mem);
    }

    public int fib(int n, int[] mem) {

        if (mem[n] != -1) {
            return mem[n];
        }
        if (n <= 2) {
            mem[n] = 1;
        } else {
            mem[n] = fib(n - 1, mem) + fib(n - 2, mem);
        }

        return mem[n];
    }
}
