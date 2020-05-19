package MultiThreading;

/**
 * @author zhuqiu
 * @date 2020/5/2
 */
public class Thread_group {

    public static void main(String[] args) {
        exceptionDeal();
    }

    public static void groupTest() {
        Thread testThread = new Thread(() -> {
            System.out.println("当前线程组名字：" +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("当前线程名字：" +
                    Thread.currentThread().getName());
        });
        ThreadGroup threadGroup = new ThreadGroup("group");
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        testThread.start();
        System.out.println("执行main方法的线程名字：" +
                Thread.currentThread().getName());
    }

    public static void exceptionDeal() {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " " + e.getMessage());
            }
        };

        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
//                throw new RuntimeException("测试异常");
                System.out.println("sd");
            }
        });

        thread1.start();
        thread1.run();
        thread1.start();
    }
}
