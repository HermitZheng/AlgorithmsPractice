package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author zhuqiu
 * @date 2020/8/13
 */
public class ProviderConsumer {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);
    private SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

    public static void main(String[] args) {

        ProviderConsumer instance = new ProviderConsumer();

        Provider provider = instance.new Provider();
        Consumer consumer = instance.new Consumer();

        provider.start();
        consumer.start();
    }

    class Provider extends Thread {

        @Override
        public void run() {
            provide();
        }

        private void provide() {
            int i = 0;
            while (i++ < 10) {
                try {
                    queue.put(1);
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            int i = 0;
            while (i++ < 10) {
                try {
                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
