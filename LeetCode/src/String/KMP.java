package String;

/**
 * @author zhuqiu
 * @date 2020/9/24
 */
public class KMP {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 3, 2, 2, 3};
        System.out.println(new KMP().chkStep(arr, arr.length));
    }

    public int chkStep(int[] arr, int n) {
        if (arr == null || arr.length == 0 || arr.length != n)
            return -1;
        return process(arr, n - 1, 1, 2, 3);
    }

    private int process(int[] arr, int i, int from, int mid, int to) {
        if (i == -1)
            return 0;
        if (arr[i] == mid)
            return -1;
        if (arr[i] == from)// 说明当前轮次的最大环还在最左边的柱子上
            return process(arr, i - 1, from, to, mid);
        else {// 在最右柱子上
            int tmp = process(arr, i - 1, mid, from, to);
            if (tmp == -1)
                return -1;
            return (1 << i) + tmp;
        }
    }
}
