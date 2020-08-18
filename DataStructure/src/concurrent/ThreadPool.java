package concurrent;

import java.util.concurrent.*;

/**
 * @author zhuqiu
 * @date 2020/8/12
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(10, 15, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Runnable runnable;
        Callable<String> callable = () -> "sd";
        Future<String> submit = executor.submit(callable);


    }
}
