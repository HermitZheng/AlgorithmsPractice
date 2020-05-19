import java.lang.reflect.Proxy;

/**
 * @author zhuqiu
 * @date 2020/4/7
 */
public class Test {

    public static void main(String[] args) {
        int i = 0;
        i = i++;
        System.out.println(i);
        MyRandom myRandom = new MyRandom();
//        Proxy.newProxyInstance(myRandom.getClass().getClassLoader(), myRandom.getClass().getInterfaces(), )
    }
}
