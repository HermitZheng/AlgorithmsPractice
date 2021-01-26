package BlockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhuqiu
 * @date 2020/12/11
 */
public class BlockingQueueWithLock<E> implements Queue<E> {

    private E[] array;
    private int head;
    private int tail;

    private volatile int size;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public BlockingQueueWithLock(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public void put(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (size == array.length) {
                notFull.await();
            }
            array[tail++] = e;
            size++;
            if (tail == array.length) {
                tail = 0;
            }
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            E res = array[head++];
            size--;
            if (head == array.length) {
                head = 0;
            }
            notFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
