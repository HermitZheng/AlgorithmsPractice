package syntax.Concurrent;

public class Test1 {
    public static void main(String[] args) {
        Runnable run = new RunnableTest();
        Thread t1 = new Thread(run, "T-1");
        t1.start();
        Thread t2 = new Thread(run, "T-2");
        t2.start();
    }
}
