package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhuqiu
 * @date 2020/8/17
 */
public class PrintABC {


    public static void main(String[] args) {

        CountDownLatch BCount = new CountDownLatch(1);

        CountDownLatch CCount = new CountDownLatch(1);

        AtomicReference<Character> alpha = new AtomicReference<>('A');

        Thread A = new Thread(() -> {
            synchronized (PrintABC.class) {
                System.out.println(alpha.getAndSet(new Character((char) (alpha.get() + 1))));

            }
//            BCount.countDown();
        });

        Thread B = new Thread(() -> {
//            try {
//                BCount.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (PrintABC.class) {
                System.out.println(alpha.getAndSet(new Character((char) (alpha.get() + 1))));

            }//            CCount.countDown();
        });

        Thread C = new Thread(() -> {
//            try {
//                CCount.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (PrintABC.class) {
                System.out.println(alpha.getAndSet(new Character((char) (alpha.get() + 1))));

            }
        });

        A.start();
        B.start();
        C.start();
    }
}
