package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhuqiu
 * @date 2020/3/27
 */
public class ListTest implements Runnable {

    static List array = new ArrayList();
    static List vector = new Vector();
    int i = 0;


    public static void main(String[] args) {
        ListTest instance = new ListTest();
        for (int i = 0; i < 200; i++) {
            new Thread(instance).start();
            new Thread(instance).start();
        }
//        System.out.println(array);
//        System.out.println(vector);
        System.out.println(Long.toBinaryString(2));
    }


    @Override
    public void run() {
        while (i < 10) {
//            array.add(i++);
            vector.add(i++);
        }

    }
}
