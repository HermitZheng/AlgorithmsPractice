package SomeClass;

import java.util.Comparator;

/**
 * @author zhuqiu
 * @date 2020/3/25
 */
public interface Animal {

    public static final String category = "animal";
    static void yourCategory(){
        System.out.println("I am "+ category);
    }
    default void yourName(){
        System.out.println("I dont have name.");
    }
}
