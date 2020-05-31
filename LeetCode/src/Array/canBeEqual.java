package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 5408 zhousai
 *
 * @author zhuqiu
 * @date 2020/5/30
 */
public class canBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        int len = target.length, alen = arr.length;
        if (len == 0 || len != alen) return false;

        Map<Integer, Integer> tar = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            tar.put(target[i], tar.getOrDefault(target[i], 0) + 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        AtomicBoolean flag = new AtomicBoolean(true);
        map.forEach((k, v) -> {
            if (!tar.containsKey(k) || tar.get(k) != v) {
                flag.set(false);
                return;
            }
        });
        return flag.get();
    }
}
