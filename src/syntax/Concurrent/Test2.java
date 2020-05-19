package syntax.Concurrent;

public class Test2 {

    public static void main(String[] args) {
        TestRun run = new TestRun();

        Thread t0 = new Thread(run);
//        t0.setPriority(8);

        Thread t1 = new Thread(run);
//        t1.setPriority(6);

        t0.start();
        t1.start();
        System.out.println(t0.getName());
        /**
         * 线程的优先级：Priority
         * 数组1-10表示，数字越大优先级越高，如果没有设置默认优先级是5
         */

        System.out.println("t0优先级是" + t0.getPriority());

        System.out.println("==========================1");
        System.out.println("==========================2");
        try {
            /**
             * 阻塞当前的main方法，先执行join的线程代码
             */
            t0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==========================3");

    }
}

class TestRun implements Runnable {
    int count;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "多线程运行的代码");
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0){
//                Thread.yield();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "多线程的逻辑代码" + count);
        }
    }
}