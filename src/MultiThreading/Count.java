package MultiThreading;

/**
 * @author zhuqiu
 * @date 2020/5/14
 */
public class Count {

    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int j = 0; j < 1000; j++) {
                i++;
//                try {
//                    Thread.sleep(30);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
//            System.out.println(i);

        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        Thread.sleep(100);
        System.out.println(i);
    }

}
