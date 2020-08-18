import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/7/12
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("he") + new String("llo");
        String s2 = new String("h") + new String("ello");
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s1);
        System.out.println(s4 == s1);
        System.out.println(s3 == s4);
        List<Integer> list = new ArrayList<>();
        Integer[] res = new Integer[list.size()];
        Integer[] integers = list.toArray(new Integer[list.size()]);
    }
}
