package Binary;

import java.util.HashSet;
import java.util.Set;

/**
 * zhousai 5409
 *
 * @author zhuqiu
 * @date 2020/5/30
 */
public class hasAllCodes {

    public static void main(String[] args) {
        boolean b = new hasAllCodes().hasAllCodes("00110110", 2);
    }

    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        if (s == null || len == 0 || k == 0) return false;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len-k; i++) {
            String temp = s.substring(i, i+k);
            set.add(temp);
        }
        return set.size() == Math.pow(2, k-1);
    }
}
