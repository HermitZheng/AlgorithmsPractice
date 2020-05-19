import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/3/16
 */
public class ReverseSentence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String sentence = scan.nextLine();
//            System.out.println(sentence);
            String reverse = reverse(sentence);
            System.out.println(reverse);
        }
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        String[] wordList = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (String s : wordList) {
            stack.push(s);
        }
        String result = new String();
        while (!stack.isEmpty()) {
            String pop = stack.pop() + " ";
            result += pop;
        }

        return result;
    }
}
