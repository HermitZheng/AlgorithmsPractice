package syntax.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {

    public static void main(String[] args) throws Exception {
        /**
         * 可以创建任意类对象，可以执行方法
         */
//        Student student = new Student();
//        student.sleep();

        // 1.加载配置文件
        // 1.1 创建properties对象
        Properties properties = new Properties();

        //1.2 加载配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(inputStream);

        //2 获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //3 加载该类进内存
        Class<?> cls = classLoader.loadClass(className);
        //4 创建对象
        Object o = cls.newInstance();
        //5 获取方法对象
        Method method = cls.getMethod(methodName);
        //6 调用方法
        method.invoke(o);



    }
}
