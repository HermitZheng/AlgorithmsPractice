package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuqiu
 * @date 2021/1/17
 */
public class CountDown extends Thread {

    public static void main(String[] args) {
        CountDownLatch counter = new CountDownLatch(10);
        for (int i = 0; i < 9; i++) {
            new CountDown(counter).start();
        }
        try {
            counter.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
    }

    CountDownLatch counter;

    public CountDown(CountDownLatch counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored){}
        System.out.println(Thread.currentThread().getName() + "线程执行完毕");
        counter.countDown();
    }
}
