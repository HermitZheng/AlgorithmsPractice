package Area;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/5/31
 */
public class CutCake {

    public static void main(String[] args) {
        int[] hor = {1};
        int[] ver = {2, 1, 5};
        int res = new CutCake().maxArea(2, 7, hor, ver);
        System.out.println(res);
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        int lenh = horizontalCuts.length;
        int maxh = Math.max(horizontalCuts[0], (h - horizontalCuts[lenh - 1]));
        for (int i = 1; i < lenh; i++) {
            maxh = Math.max(maxh, (horizontalCuts[i] - horizontalCuts[i - 1]));
        }

        Arrays.sort(verticalCuts);
        int lenw = verticalCuts.length;
        int maxw = Math.max(verticalCuts[0], (w - verticalCuts[lenw - 1]));
        for (int i = 1; i < lenw; i++) {
            maxw = Math.max(maxw, (verticalCuts[i] - verticalCuts[i - 1]));
        }
        return (int)(((long)maxh * (long)maxw) % 1000000007);
    }
}
