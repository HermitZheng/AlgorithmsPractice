package fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author zhuqiu
 * @date 2021/1/11
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i <= 1000000000; i++) {
           sum += i;
        }
        System.out.println(sum);

        long end = System.currentTimeMillis();
        System.out.println("for: " + (end-start));

        // -----------------------------------


        CountTask countTask = new CountTask(0, 1000000000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        start = System.currentTimeMillis();
        Integer submit = forkJoinPool.invoke(countTask);
        System.out.println(submit);

        end = System.currentTimeMillis();
        System.out.println("fork-join:" + (end-start));
    }
}
