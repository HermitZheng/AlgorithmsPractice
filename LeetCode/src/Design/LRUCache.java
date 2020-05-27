package Design;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/5/25
 */
public class LRUCache {

//    Map<Integer, Integer> cache;
//    Queue<Integer> lru;
//    int capacity;
//
//    public LRUCache(int capacity) {
//        cache = new HashMap<>(capacity);
//        lru = new LinkedList<>();
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (!cache.containsKey(key)) return -1;
//        lru.remove(key);
//        lru.add(key);
//        return cache.get(key);
//    }
//
//    public void put(int key, int value) {
//        if (cache.containsKey(key)) {
//            lru.remove(key);
//
//        } else if (capacity == 0) {
//            cache.remove(lru.poll());
////            cache.put(key, value);
////            lru.add(key);
//        } else {
////            cache.put(key, value);
////            lru.add(key);
//            capacity--;
//        }
//        cache.put(key, value);
//        lru.add(key);
//    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    private LRU lru;

    class LRU<K, V> extends LinkedHashMap {
        private int capacity;
        public LRU(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }

    public LRUCache(int capacity) {
        lru = new LRU(capacity);
    }

    public int get(int key) {
        return (int) lru.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lru.put(key, value);
    }
 }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
