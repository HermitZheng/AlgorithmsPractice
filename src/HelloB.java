import java.util.Iterator;
import java.util.Queue;

/**
 * @author zhuqiu
 * @date 2020/3/14
 */

    public class HelloB extends HelloA
    {
        public HelloB()
        {
        }
        {
            System.out.println("I’m B class");
        }
        static {
            System.out.println("static B");
        }
        public static void main(String[] args)
        {
            Integer a = 1;
            Integer b = (Integer) a;
//            new HelloB();
            short a1 = 2;
            byte a2 = 1;
            byte a3 = a2;

            for (int i = 0; i < 65; i++) {
                b += i;
            }
            System.out.println(b);
        }
    }
    class HelloA
    {
        public HelloA()
        {
        }
        {
            System.out.println("I’m A class");
        }
        static
        {
            System.out.println("static A");
        }
    }

