package concurrent;

/**
 * @author zhuqiu
 * @date 2020/9/12
 */
public class DeadLock {

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread threadA = new Thread() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("已经获取锁A，尝试获取锁B");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB) {
                        System.out.println("获取到锁AB");
                    }
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                synchronized (lockB) {
                    System.out.println("已经获取锁B，尝试获取锁A");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA) {
                        System.out.println("获取到锁AB");
                    }
                }
            }
        };

        threadA.start();
        threadB.start();
    }


}

