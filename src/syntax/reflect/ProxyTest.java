package syntax.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        /**
         * 如果一个对象想要通过Proxy.newProxyInstance被代理
         * 那么这个对象的类一定要有相应的接口
         * （如 TestDemo 接口 以及 TestDemoImpl 实现）
         */
        TestDemo test = new TestDemoImpl();

        test.test1();
        test.test2();

        System.out.println("====================================================");

        /**
         * 在执行test1和test2时加入一些功能
         * 在执行方法前打印test开始执行
         * 在执行方法后打印test执行完毕
         * 打印的方法名要和调用的方法一致
         */

        InvocationHandler handler = new ProxyDemo(test); // 代理对象
        /**
         * 参数一：被代理对象的类加载器
         * 参数二：被代理的对象的接口
         * 参数三：代理对象
         *
         * 返回值是成功被代理后的对象，返回Object类型
         */
        TestDemo testDemo = (TestDemo) Proxy.newProxyInstance(test.getClass().getClassLoader(),
                test.getClass().getInterfaces(), handler);

        testDemo.test1();
        testDemo.test2();

    }
}
