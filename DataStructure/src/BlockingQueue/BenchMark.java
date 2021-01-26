package BlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuqiu
 * @date 2020/12/11
 */
public class BenchMark {

    public static void main(String[] args) {
        new BenchMark().testWithCondition();
//        new BenchMark().testWithMonitor();
    }

    public void testWithMonitor() {
        Queue<Integer> queue = new BlockingQueueWithSync<>(5);
        execute(queue);
    }

    public void testWithCondition() {
        Queue<Integer> queue = new BlockingQueueWithLock<>(5);
        execute(queue);
    }

    private void execute(Queue<Integer> queue) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            final int finalNum = i;
            executorService.execute(() -> {
                try {
                    queue.put(finalNum);
                    Integer take = queue.take();
                    System.out.println("Item: " + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        long end = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        System.out.println("程序运行时间: " + (end - start));
        executorService.shutdown();
    }
}
