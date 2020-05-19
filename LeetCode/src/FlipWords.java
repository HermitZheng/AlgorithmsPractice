/**
 * @author zhuqiu
 * @date 2020/4/10
 */
public class FlipWords {

    public static void main(String[] args) {
        String s= "a good   example" ;
        System.out.println(new FlipWords().reverseWords(s));
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] list = s.split(" +");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.length-1; i >= 0; i--) {
            stringBuilder.append(list[i].trim());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
