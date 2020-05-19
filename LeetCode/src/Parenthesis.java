import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/4/9
 */
public class Parenthesis {

    List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        new Parenthesis().generateParenthesis(3).forEach(s -> System.out.println(s));
    }

    public List<String> generateParenthesis(int n) {
        backTrack(new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backTrack(StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max*2) {
            list.add(cur.toString());
            return;
        }

        if (left < max) {
            cur.append('(');
            backTrack(cur, left+1, right, max);
            cur.deleteCharAt(cur.length()-1);
        }

        if (right < left) {
            cur.append(')');
            backTrack(cur, left, right+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
