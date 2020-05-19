package String;

import java.util.ArrayList;

/**
 * @author zhuqiu
 * @date 2020/4/19
 */
public class reformatString {

    public static void main(String[] args) {
        String s = "ab123";
        String reformat = new reformatString().reformat(s);
        System.out.println(reformat);
    }


    public String reformat(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        ArrayList<Character> nums = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        for(int i=0; i<len; i++) {
            if(s.charAt(i)>='0' && s.charAt(i) <= '9') {
                nums.add(s.charAt(i));
            } else {
                chars.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        int nlen = nums.size(), clen = chars.size();
        if (Math.abs(nlen-clen) > 1) {
            return "";
        }
        if (nlen > clen) {
            sb.append(nums.get(0));
            for (int i = 0; i < clen; i++) {
                sb.append(chars.get(i));
                sb.append(nums.get(i+1));
            }
        } else if (clen > nlen){
            sb.append(chars.get(0));
            for (int i = 0; i < nlen; i++) {
                sb.append(nums.get(i));
                sb.append(chars.get(i+1));
            }
        } else {
            for (int i = 0; i < clen; i++) {
                sb.append(chars.get(i));
                sb.append(nums.get(i));
            }
        }
        return sb.toString();
    }
}
