package concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuqiu
 * @date 2021/1/20
 */
public class Racing extends Thread {

    public static void main(String[] args) {
        CountDownLatch counter = new CountDownLatch(10);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            executor.submit(new Racing(counter, i));
        }
    }

    CountDownLatch counter;
    int name;

    public Racing(CountDownLatch countDownLatch, int name) {
        this.counter = countDownLatch;
        this.name = name;
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(name + "号赛车已就绪，等待其他赛车");
        counter.countDown();
        counter.await();
        System.out.println("所有赛车已就绪，" + name + "号赛车出发");
    }
}
