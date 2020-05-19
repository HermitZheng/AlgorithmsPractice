import java.util.Scanner;
import java.util.Stack;

/**
 * @author zhuqiu
 * @date 2020/3/23
 */
public class PasswordStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String password = new String();
            for (int i = 0; i < 3; i++) {
                password += in.nextLine();
            }
            boolean result = isMirror(password);
            if (result == true){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


    public static boolean isMirror(String string) {
        if (string == null){
            return false;
        }
        Stack stack = new Stack();
        String pre = string.substring(0, 4);
        String post = string.substring(5, 9);

        for (int i = 0; i < 4; i++) {
            stack.push(pre.substring(i, i+1));
        }
        for (int i = 0; i < 4; i++) {
            if (!String.valueOf(stack.pop()).equals(post.substring(i, i+1))){
                return false;
            }
        }
        return true;
    }
}
