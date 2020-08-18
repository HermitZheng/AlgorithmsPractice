package Demand;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/7/13
 */
public class ComputerStore {

    static List<Object> computers = Collections.synchronizedList(new LinkedList<>());

    public static void main(String[] args) {
        PC pc = new PC();
        PC pc1 = new PC();
        Note note = new Note();
        add(note);
        add(pc);
        add(note);
        add(pc1);
        System.out.println(computers.get(0) == computers.get(0));
        Computer com = getByType(ComputerType.PC);
        System.out.print(com == pc);
        com = getRandom();
        System.out.println(com);
    }

    /**
     * 添加一台电脑
     * @param computer  电脑实体
     */
    public static void add(Computer computer) {
        // 尾插
        computers.add(computer);
    }

    /**
     * 根据类型获取一台电脑
     * @param type  所需类型
     * @param <T>   类型
     * @return      该类型的电脑
     */
    public static <T extends Computer> T getByType(ComputerType type) {
        if (computers.isEmpty()) return null;
        T result = null;
        for (int i = 0; i < computers.size(); i++) {
            // 根据类型找到最早加入的电脑
            if (type.getType().equals(computers.get(i).getClass())) {
                result = (T) computers.get(i);
                computers.remove(i);
                break;
            }
        }
        return result;
    }

    /**
     * 随意获取一台电脑
     * @param <T>   任意类型
     * @return      该类型的电脑
     */
    public static <T extends Computer> T getRandom() {
        if (computers.isEmpty()) return null;
        T result = (T) computers.get(0);
        computers.remove(0);
        return result;
    }

    /**
     * 枚举类
     */
    enum ComputerType {

        PC(ComputerStore.PC.class),
        Note(ComputerStore.Note.class);

        Class<? extends Computer> type;

        ComputerType(Class<? extends Computer> type) {
            this.type = type;
        }

        public Class<? extends Computer> getType() {
            return type;
        }
    }

    /**
     * 电脑的父类
     */
    static class Computer {
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

    static class PC extends Computer {

    }

    static class Note extends Computer {
    }
}
