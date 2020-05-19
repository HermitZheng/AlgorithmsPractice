package MultiThreading;

/**
 * @author zhuqiu
 * @date 2020/5/2
 */
public class blockedTest {

    public static void main(String[] args) throws InterruptedException {
        new blockedTest().blockedTest();
    }

    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
//        Thread.sleep(2000L);
        b.start();
//        Thread.sleep(2000L);
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
//        Thread.sleep(2500L);
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
