package SomeClass;

/**
 * @author zhuqiu
 * @date 2020/3/25
 */
public class Dog implements Animal {

    public void yourCategory(){
        System.out.println("I am dog");
    }
    public final void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {
        creature what = new what();
        what.what();
    }

}

class LittleDog extends Dog {


    private String name;
    public static void main(String[] args) {
        Dog dog = new LittleDog();
        dog.yourCategory();
//        LittleDog.yourCategory();
//        Dog.yourCategory();
    }

    public void yourCategory() {
        System.out.println("i am little");
    }
}

abstract class creature extends Dog {

    abstract void what();
}

class what extends creature {

    @Override
    void what() {

    }
}
