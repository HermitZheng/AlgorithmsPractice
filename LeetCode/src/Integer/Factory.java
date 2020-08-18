package Integer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/6/27
 */
public class Factory {

    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>(k);
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (count == k) return list.get(k-1);
            if (n % i == 0) {
                list.add(i);
                count++;
            }
        }
        if (k > list.size()) return -1;
        return list.get(k-1);
    }
}
