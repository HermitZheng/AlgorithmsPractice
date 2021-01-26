package Proxy;

import Proxy.service.TestService;
import Proxy.service.impl.TestServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuqiu
 * @date 2021/1/17
 */
public class MyProxy {

    public static void main(String[] args) {
        TestService proxy = (TestService) new MyHandler(new TestServiceImpl()).getProxy();
        proxy.hello();
    }
}

class MyHandler implements InvocationHandler {

    Object bean;

    public MyHandler(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理");
        method.invoke(bean, args);
        return null;
    }
}

