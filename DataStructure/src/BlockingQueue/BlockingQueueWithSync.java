package BlockingQueue;


/**
 * @author zhuqiu
 * @date 2020/12/11
 */
public class BlockingQueueWithSync<E> implements Queue<E> {

    private E[] array;
    private int head;
    private int tail;

    private volatile int size;

    public BlockingQueueWithSync(int capacity) {
        array = (E[]) new Object[capacity];
    }


    @Override
    public synchronized void put(E e) throws InterruptedException {
        while (size == array.length) {
            this.wait();
        }
        array[tail++] = e;
        if (tail == array.length) {
            tail = 0;
        }
        size++;
        this.notifyAll();
    }

    @Override
    public synchronized E take() throws InterruptedException {
        while (size == 0) {
            this.wait();
        }
        E res = array[tail--];
        if (++head == array.length) {
            head = 0;
        }
        size--;
        this.notifyAll();
        return res;
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

