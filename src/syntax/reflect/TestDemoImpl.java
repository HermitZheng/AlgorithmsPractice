package syntax.reflect;


public class TestDemoImpl implements TestDemo {
    @Override
    public void test1() {
        System.out.println("执行方法一");
    }

    @Override
    public void test2() {
        System.out.println("执行方法二");
    }
}
