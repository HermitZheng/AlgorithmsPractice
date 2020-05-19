import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author zhuqiu
 * @date 2020/3/16
 */
public class ForTest {

    public static void main(String[] args) {

        Optional<String> optString = Optional.ofNullable("test");
        optString.ifPresent(s -> System.out.println("yes?" + s.length()));
        Optional<Integer> news = optString.ofNullable("null")
                .map(s -> s.length())
                .map(integer -> integer.intValue());
        optString.ifPresent(s -> System.out.println(s));
        System.out.println(news.toString());
    }

    private static int engine(Calculate calculate) {
        int x = 2, y = 4;
        int result = calculate.calculate(x, y);
        return result;
    }
}

@FunctionalInterface
interface Calculate {
    int calculate(int x, int y);
}
