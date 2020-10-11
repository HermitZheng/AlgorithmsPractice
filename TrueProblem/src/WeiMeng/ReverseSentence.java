package WeiMeng;

/**
 * @author zhuqiu
 * @date 2020/9/6
 */
public class ReverseSentence {

    public static void main(String[] args) {
        String str = "There is a dog.";
        char[] cs = str.toCharArray();
        String res = new ReverseSentence().reverseWord(str);

        System.out.println(res);
    }

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i++) {
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            if (i == s.length()) {
                break;
            }
            int begin = i;
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
            i--;
            int end = i;
            while (end >= begin) {
                sb.append(s.charAt(end));
                end--;
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    /**
     * @param str string字符串
     * @return string字符串
     */
    public String reverseWord(String str) {
        // write code here
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();

        outer:
        while (right < str.length()) {
            char c = str.charAt(right);

            while ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                right++;
                if (right == str.length()) {
                    break outer;
                }
                c = str.charAt(right);
            }

            for (int i = right - 1; i >= left; i--) {
                sb.append(str.charAt(i));
            }

            while (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                sb.append(str.charAt(right));
                right++;
                if (right == str.length()) {
                    break outer;
                }
                c = str.charAt(right);
            }

            left = right;
        }
        return sb.toString().trim();
    }
}
