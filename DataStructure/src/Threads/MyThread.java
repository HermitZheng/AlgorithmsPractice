package Threads;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author zhuqiu
 * @date 2020/12/15
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("fole");
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(() -> {
            System.out.println("sd");
            System.out.println("fole");
        });
        TreeMap<Integer, Integer> map = new TreeMap<>((x, y) -> {
            System.out.println("sd");
            return 0;
        });

        Comparator<Integer> comparator = (x, y) -> {
            return x - y;
        };
    }
}
