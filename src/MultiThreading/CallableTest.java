package MultiThreading;

import java.util.concurrent.*;

/**
 * @author zhuqiu
 * @date 2020/4/30
 */
public class CallableTest implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CallableTest test = new CallableTest();
        Future<?> future = executor.submit(test);

        FutureTask<Integer> futureTask = new FutureTask<>(new CallableTest());
        executor.submit(futureTask);

        System.out.println(futureTask.cancel(false));
        System.out.println(futureTask.isCancelled());
//        System.out.println(futureTask.get());


        System.out.println(future.get());
    }
}
