package BlockingQueue;

/**
 * @author zhuqiu
 * @date 2020/12/11
 */
public interface Queue<E> {

    void put(E e) throws InterruptedException;

    E take() throws InterruptedException;

    int size();

    boolean isEmpty();
}
