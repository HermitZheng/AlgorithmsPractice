package stack;

/**
 * @author zhuqiu
 * @date 2020/2/17
 */
public class Demo {

    public static void main(String[] args) {
        LinkStack stack = new LinkStack(5);

        stack.pop();

        stack.push('1');
        stack.push(3);
        stack.push(7);
        stack.push(7);
        stack.push(7);

        LinkStack.StackNode pop = stack.pop();
        System.out.println(pop.toString());

        stack.push(10);


        stack.list();
    }
}
