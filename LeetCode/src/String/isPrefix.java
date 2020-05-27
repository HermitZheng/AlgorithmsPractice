package String;

/**
 * @author zhuqiu
 * @date 2020/5/24
 */
public class isPrefix {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        int len = searchWord.length();
        outer:
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            for (int j=0; j<len; j++) {
                if (j == s.length() || s.charAt(j) != searchWord.charAt(j)){
                    continue outer;
                }
            }
            return i+1;
        }
        return -1;
    }
}
