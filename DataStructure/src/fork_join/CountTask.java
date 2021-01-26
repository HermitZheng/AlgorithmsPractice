package fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * @author zhuqiu
 * @date 2021/1/11
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final Integer THRESHOLD = 10;
    private int left;
    private int right;

    public CountTask(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (right-left <= THRESHOLD) {
            for (; left <= right; left++) {
                sum += left;
            }
        } else {
            int mid = (right + left) >> 1;
            CountTask leftTask = new CountTask(left, mid);
            CountTask rightTask = new CountTask(mid + 1, right);

//            leftTask.fork();
//            rightTask.fork();
            invokeAll(leftTask, rightTask);

            int leftCount = leftTask.join();
            int rightCount = rightTask.join();
            sum = leftCount + rightCount;
        }
        return sum;
    }
}
