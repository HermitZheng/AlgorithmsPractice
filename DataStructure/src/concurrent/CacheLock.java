package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 缓存击穿的解决方案之一：互斥锁
 * 缓存击穿不同的是缓存击穿是指一个Key非常热点，在不停的扛着大并发
 * 当这个Key在失效的瞬间，持续的大并发就穿破缓存
 *
 * @author zhuqiu
 * @date 2020/8/19
 */
public class CacheLock {

    static Lock lock = new ReentrantLock();

    public static String getDate(String key) throws InterruptedException {
        // 尝试从缓存中拿
        String result = getDataByKV(key);
        // 缓存空了
        if (!result.equals("")) {
            // 能获取到锁
            if (lock.tryLock()) {
                // 从数据库中拿到最新的数据
                result = getDataByDB(key);
                // 更新到缓存;
                if (!result.equals("")) {
                    setDataToKV(key, result);
                }
                lock.unlock();
            } else {
                // 拿不到锁的话，过一会再试
                // 如果其他线程已经刷新过缓存，那就可以直接拿到了
                Thread.sleep(100L);
                result = getDate(key);
            }
        }
        return result;
    }

    private static void setDataToKV(String key, String result) {

    }

    private static String getDataByKV(String key) {
        return null;
    }

    private static String getDataByDB(String key) {
        return null;
    }
}
