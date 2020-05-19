package Substring;

/**
 * @author zhuqiu
 * @date 2020/4/13
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"", "flow", "flight"};
        String result = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            char key = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != key) {
                    break outer;
                }
            }
            sb.append(key);
        }

        return sb.toString();
    }
}
