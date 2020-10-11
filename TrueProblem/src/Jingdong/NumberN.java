package Jingdong;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/8/27
 */
public class NumberN {

    static int size = 0;
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        size = n;

//        int[] nums = {2, 3, 5};
        String[] nums = {"2", "3", "5"};
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        dfs(nums, 3, 0, sb);
        Collections.sort(res);
        System.out.println(res.get(n-1));
    }


    private static void dfs(String[] nums, int len, int depth, StringBuilder sb) {
        if (Math.pow(3, depth) > size) {
            return;
        }
        if (res.size() >= Math.pow(size, 3)) {
            return;
        }
        res.add(sb.toString());

        for (int i = 0; i < len; i++) {
            sb.append(nums[i]);
            dfs(nums, len, depth+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
