package SouGou;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/9/5
 */
public class NewPassword {

    public static void main(String[] args) {
        long res = new NewPassword().getPasswordCount("12345");
        System.out.println(res);
    }

    char[] list;
    String pass;
    int count = 0;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回生成的新密码个数
     * @param password string字符串 密码的数组字符串（长度小于50），例如 12345
     * @return long长整型
     */
    public long getPasswordCount (String password) {
        // write code here
        pass = password;
        list = password.toCharArray();

        for (int i = 0; i <= 9; i++) {
            dfs(String.valueOf(i), 1, i);
        }
        return count-1;
    }

    private void dfs(String sb, int pos, int pre) {
        if (pos >= list.length) {
//            if (!sb.equals(pass)) {
                count++;
//            }
            return;
        }
        double avg = (pre + Integer.valueOf(list[pos])) / 2.0;
        if (Math.floor(avg) == Math.ceil(avg)) {
            dfs(sb + avg, pos+1, (int) avg);
        } else {
            int floor = (int) Math.floor(avg);
            int ceil = (int) Math.ceil(avg);
            dfs(sb + floor, pos+1, floor);
            dfs(sb + ceil, pos+1, ceil);
        }
    }

}
