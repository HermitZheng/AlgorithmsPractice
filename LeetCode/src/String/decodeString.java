package String;

/**
 * leetcode 394
 *
 * @author zhuqiu
 * @date 2020/5/28
 */
public class decodeString {

    public static void main(String[] args) {
        String s = "2[abc]3[cd]e";
        String res = new decodeString().decodeString(s);
        System.out.println(res);
    }

    int i = 0;

    public String decodeString(String s) {
        int len = s.length();
        if (len == 0) return "";
        StringBuilder sb = new StringBuilder();
        String num = "", chars = "";
        while (i < len) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(decodeOne(s));
            }
            else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    public String decodeOne(String s) {
        int len = s. length();
        String num = "", chars = "";
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            char c = s.charAt(i++);
            if (c >= '0' && c <= '9') num += c;
            else if (c == '[') {
                int count = Integer.parseInt(num);
                while ((c = s.charAt(i)) != ']') {
                    if (c >= '0' && c <= '9') chars += decodeOne(s);
                    else chars += s.charAt(i++);
                }
                for (int j = 0; j < count; j++) {
                    sb.append(chars);
                }
                i++;
                break;
            }
        }
        return sb.toString();
    }
}
