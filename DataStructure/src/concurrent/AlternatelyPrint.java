package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuqiu
 * @date 2020/8/14
 */

public class AlternatelyPrint {

    public static void main(String[] args) {
        ResForPrint res = new ResForPrint();
//        Nums n = new Nums(res);
//        Alpha a = new Alpha(res);
//
//        Thread t1 = new Thread(n);
//        Thread t2 = new Thread(a);


        Thread test1 = new Thread(() -> {
            for (int i=0; i<10; i++) {
                res.printNum();
            }
        });

        Thread test2 = new Thread(() -> {
            for (int i=0; i<10; i++) {
                res.printAlpha();
            }
        });

        test1.start();
        test2.start();


//        t1.start();
//        t2.start();

    }
}

class Nums implements Runnable {

    private ResForPrint instance;

    public Nums(ResForPrint instance) {
        this.instance = instance;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            instance.printNum();
        }
    }
}

class Alpha implements Runnable {

    private ResForPrint instance;

    public Alpha(ResForPrint instance) {
        this.instance = instance;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            instance.printAlpha();
        }
    }
}

class ResForPrint {

    int num = 1;
    char c = 'a';

    private boolean flag = true;
    private Lock lock = new ReentrantLock();
    private Condition nums = lock.newCondition();
    private Condition alphas = lock.newCondition();

    public void printNum() {
        lock.lock();
        try {
            while (flag) {
                try {

                    nums.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(num);
            num++;
            // 为了防止自己又一次执行，循环await()
            flag = true;
            alphas.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printAlpha() {
        lock.lock();
        try {
            while (!flag) {
                try {

                    alphas.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(c);
            c++;
            // 为了防止自己又一次执行，循环await()
            flag = false;
            nums.signal();
        } finally {
            lock.unlock();
        }
    }
}



