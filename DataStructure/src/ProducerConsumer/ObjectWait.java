package ProducerConsumer;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author zhuqiu
 * @date 2020/10/8
 */
public class ObjectWait {

    public static void main(String[] args) {
        ObjectWait container = new ObjectWait();

        Thread producer1 = new Thread(new Producer(container));
        Thread producer2 = new Thread(new Producer(container));
//        Thread producer3 = new Thread(new Producer(container));
//        Thread producer4 = new Thread(new Producer(container));
        producer1.start();
        producer2.start();
//        producer3.start();
//        producer4.start();

        Thread consumer1 = new Thread(new Consumer(container));
//        Thread consumer2 = new Thread(new Consumer(container));
//        Thread consumer3 = new Thread(new Consumer(container));
//        Thread consumer4 = new Thread(new Consumer(container));
//        Thread consumer5 = new Thread(new Consumer(container));
//        Thread consumer6 = new Thread(new Consumer(container));
        consumer1.start();
//        consumer2.start();
//        consumer3.start();
//        consumer4.start();
//        consumer5.start();
//        consumer6.start();
    }
    int capacity = 10;
    LinkedList<Integer> list = new LinkedList<>();

    public void put() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                while (list.size() == capacity) {
                    System.out.println("缓冲区满了，等待消费");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = new Random().nextInt(100);
                System.out.println("Producer -- " + Thread.currentThread().getName() + "-- put value:" + value);
                list.add(value);
                notifyAll();
            }
        }
    }

    public Integer take() {
        Integer value = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                while (list.size() == 0) {
                    System.out.println("缓冲区为空，等待生产");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                value = list.removeFirst();
                System.out.println("Consumer -- " + Thread.currentThread().getName() + " -- take value: " + value);
                notifyAll();
            }
        }
    }
}

class Producer implements Runnable {
    private ObjectWait container;
    public Producer(ObjectWait container) {
        this.container = container;
    }

    @Override
    public void run() {
        container.put();
    }
}

class Consumer implements Runnable {
    private ObjectWait container;
    public Consumer(ObjectWait container) {
        this.container = container;
    }

    @Override
    public void run() {
        container.take();
    }
}
