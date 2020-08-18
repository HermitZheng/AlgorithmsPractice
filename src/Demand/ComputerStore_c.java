package Demand;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuqiu
 * @date 2020/7/13
 */
public class ComputerStore_c {

    /**
     * 用于存储不同类型的电脑
     */
    private HashMap<ComputerType, Queue<Computer>> map;

    /**
     * 用于记录最近添加的电脑
     */
    private Queue<ComputerType> queue;


    public ComputerStore_c() {
        map = new HashMap<>();
        queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        ComputerStore_c store = new ComputerStore_c();
        store.addComputer(ComputerType.PC, store.new PC());
        Computer randComputer = store.getComputerByType(ComputerType.PC);
        System.out.println(randComputer.getClass());
    }

    /**
     * 根据所给类型，返回不同类型的实体
     *
     * @param type 枚举类，电脑类型
     * @param <T>  某电脑类型
     * @return 该类型的实体
     */
    public synchronized <T extends Computer> T getComputerByType(ComputerType type) {
        // 根据所需类型，返回一台电脑
        T computer = (T) map.get(type).poll();
        // 临时储存
        Stack<ComputerType> temp = new Stack<>();

        // 移除 最近添加电脑 记录中的该台电脑
        while (queue.peek() != type) {
            temp.push(queue.poll());
        }
        queue.poll();
        while (!temp.isEmpty()) {
            queue.offer(temp.pop());
        }
        return computer;
    }

    /**
     * 添加一台电脑
     *
     * @param computer 任意类型的电脑
     */
    public synchronized void addComputer(ComputerType type, Computer computer) {
        map.putIfAbsent(type, new LinkedList<>());
        // 根据所提供电脑的类型，加入不同的队列中
        map.get(type).offer(computer);
        // 记录最新添加的电脑
        queue.offer(type);
    }

    /**
     * 随便获取一台最早的电脑
     *
     * @param <T> 最早电脑的类型
     * @return 最早电脑的实体
     */
    public synchronized <T extends Computer> T getRandComputer() {
        ComputerType type = queue.poll();
        return (T) map.get(type).poll();
    }

    /**
     * 枚举类
     */
    enum ComputerType {

        PC,
        Note
    }

    /**
     * 电脑的父类
     */
    class Computer {
        Long id;
        String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class PC extends Computer {

    }

    class Note extends Computer {
    }
}
