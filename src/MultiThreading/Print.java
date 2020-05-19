package MultiThreading;

/**
 * @author zhuqiu
 * @date 2020/5/9
 */
public class Print {

    static Object lock = new Object();
    static int sym = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
//            while (sym < 20) {
//                System.out.println("ThreadA-" + Thread.currentThread().getName());
//                if (sym % 2 == 0) {
//                    System.out.println("A——" + sym);
//                    sym++;
//                }
//            }
            for (int i = 0; i < 10; i++) {
                    System.out.println("A——" + sym++);
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
//            while (sym < 20) {
//                System.out.println("ThreadB-" + Thread.currentThread().getName());
//                if (sym % 2 == 1) {
//                    System.out.println("B——" + sym);
//                    sym++;
//                }
//            }
            for (int i = 0; i < 10; i++) {
                    System.out.println("B——" + sym++);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
//        new Thread(new WaitNotify(), "奇数").start();
//        new Thread(new WaitNotify(), "偶数").start();
    }

    static class WaitNotify implements Runnable {

        static int value = 1;
        @Override
        public void run() {
            while (value < 20) {
                synchronized (WaitNotify.class) {
                    System.out.println(Thread.currentThread().getName() + value++);
                    WaitNotify.class.notify();
                    try {
                        WaitNotify.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
