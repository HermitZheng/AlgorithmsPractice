package BaiDu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/9/14
 */
public class Role {

    public static void main(String[] args) throws IOException {
//            Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int term = Integer.parseInt(in.readLine());


        for (int t = 0; t < term; t++) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            String[] plist = in.readLine().split(" ");
            String[] roles = in.readLine().split(" ");
//                int[] plist = new int[n];
//                int[] roles = new int[m];
//                for (int i = 0; i < n; i++) {
//                    plist[i] = in.nextInt();
//                }
//                for (int i = 0; i < m; i++) {
//                    roles[i] = in.nextInt();
//                }
            choose(plist, roles, n, m);
        }
    }

    private static void choose(int[] plist, int[] roles, int n, int m) {
//            Arrays.sort(plist);
//            Arrays.sort(roles);

        int i = 0, j = 0;

        for (int p : plist) {
            while (j < m && roles[j] < p) {
                j++;
            }
            System.out.print((m - j) + " ");
        }
    }

    private static void choose(String[] plist, String[] roles, int n, int m) {
        Arrays.sort(plist);
        Arrays.sort(roles);
        int i = 0, j = 0;

        for (String p : plist) {
            while (j < m && Integer.parseInt(roles[j]) < Integer.parseInt(p)) {
                j++;
            }
            System.out.print((m - j) + " ");
        }
    }
}
