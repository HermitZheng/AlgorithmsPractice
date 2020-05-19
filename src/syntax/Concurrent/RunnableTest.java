package syntax.Concurrent;

public class RunnableTest implements Runnable{
    int count = 0;
    public static void main(String[] args) {

    }

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
            System.out.print(Thread.currentThread().getName());
            count++;
            System.out.println("多线程的逻辑代码" + count);
        }
    }

}
