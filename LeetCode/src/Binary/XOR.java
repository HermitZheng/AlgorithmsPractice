package Binary;

/**
 * @author zhuqiu
 * @date 2020/6/21
 */
public class XOR {


    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 0; i < n - 1; i++) {
            start += 2;
            res ^= start;
        }
        return res;
    }
}
