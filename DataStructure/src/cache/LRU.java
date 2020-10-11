package cache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuqiu
 * @date 2020/9/20
 */
public class LRU {

    public static void main(String[] args) {
        int[][] operation = {{1,1,1}
                            ,{1,2,2}
                            ,{1,3,2}
                            ,{2,1}
                            ,{1,4,4}
                            ,{2,2}};
        int k = 3;
        int[] res = new LRU().LRU(operation, k);

        for (int i : res) {
            System.out.println(i);
        }
    }

    static class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int size;

    public int[] LRU(int[][] operation, int k) {
        head.next = tail;
        tail.prev = head;
        size = k;

        int count = (int) Arrays.stream(operation).filter(x -> x[0] == 2).count();
        int[] res = new int[count];
        int i = 0;
        for (int[] ope : operation) {
            if (ope[0] == 2) {
                res[i++] = get(ope[1]);
            } else {
                set(ope[1], ope[2]);
            }
        }
        return res;
    }

    private int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private void set(int key, int value) {
        if (get(key) > -1) {
            map.get(key).value = value;
        } else {
            if (map.size() == size) {
                int rm = tail.prev.key;
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                map.remove(rm);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
        }
    }


    private void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

}
