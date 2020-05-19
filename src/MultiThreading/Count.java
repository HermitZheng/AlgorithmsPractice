package MultiThreading;

/**
 * @author zhuqiu
 * @date 2020/5/14
 */
public class Count {

    private static int i = 0;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int j = 0; j < 2; j++) {
                i++;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);

        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
