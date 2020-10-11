package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuqiu
 * @date 2020/8/17
 */
public class MultiAdd {

    static int i = 0;

    public static void main(String[] args) {
        test_syn();
    }

    public static void test_syn() {
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                System.out.println(i++);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 1000; j++) {
                System.out.println(i++);
            }
        });
        t1.start();
        t2.start();
    }

    public static void test_atomic() {
        AtomicInteger i = new AtomicInteger();

        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                synchronized (MultiAdd.class) {
                    System.out.println(i.getAndIncrement());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                synchronized (MultiAdd.class) {
                    System.out.println(i.getAndIncrement());
                }
            }
        });
        t1.start();
        t2.start();
    }
}
