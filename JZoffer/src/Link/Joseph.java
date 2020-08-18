package Link;

import java.util.LinkedList;
import java.util.List;

/**
 * lc.offer 62
 *
 * @author zhuqiu
 * @date 2020/8/6
 */
public class Joseph {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<n; i++) {
            list.add(i);
        }
        int rm = m-1;
        for (int i=0; i<n-1; i++) {
            System.out.println(rm);
            list.remove(rm);
            rm = (rm + m-1) % list.size();
        }
        return list.get(0);
    }

    public int joseph(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
