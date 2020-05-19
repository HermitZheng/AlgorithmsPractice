package MultiThreading;

/**
 * @author zhuqiu
 * @date 2020/4/4
 */
public class NoStop {


    public static void main(String args[]) {
        ARunnable ar = new ARunnable();
        new Thread(ar).start();
        ar.tellToStop();
    }

    static class ARunnable implements Runnable {

        volatile boolean stop;

        void tellToStop() {
            stop = true;
        }

        @Override
        public void run() {
            try{
                System.out.println("进入不可停止区域 1。。。");
                Thread.sleep(1000);
                System.out.println("退出不可停止区域 1。。。");
                System.out.println("检测标志stop = " + String.valueOf(stop));
                if (stop) {
                    System.out.println("停止执行");
                    return;
                }
                System.out.println("进入不可停止区域 2。。。");
                Thread.sleep(1000);
                System.out.println("退出不可停止区域 2。。。");
            }catch (Exception e) {

            }

        }

    }
}
