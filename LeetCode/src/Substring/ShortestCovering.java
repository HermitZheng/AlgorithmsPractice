package Substring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 76
 *
 * @author zhuqiu
 * @date 2020/5/23
 */
public class ShortestCovering {

    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen == 0|| tlen == 0 || tlen > slen) return "";
        char[] ts = t.toCharArray();
        char[] ss = s.toCharArray();

        int mlen = slen + 1;    // 最小子串的长度
        int left = 0, right = 0, distance = 0;      // distance代表当前窗口和目标直接，相差元素的个数：distance == tlen时相同
        int begin = 0;  // 最小子串的开始位置
        int[] winFreq = new int[128];   // 记录窗口中每个元素的个数
        int[] tFreq = new int[128];     // 目标子串每个元素的个数
        for (char c : ts) {
            tFreq[c]++;
        }

        // [left, right)
        while (right < slen) {
//            if (tFreq[ss[right]] == 0) {    // right位置的元素不在目标中，可以忽略，right++
//                right++;
//                continue;
//            }
            // 此时right指向的元素在目标中
            if (winFreq[ss[right]] < tFreq[ss[right]]) {    // 当前窗口中这个元素的个数，没有超过子串要求的个数
                distance++;
            }
            winFreq[ss[right]]++;   // 更新窗口中的元素
            right++;

            while (distance == tlen) {  // 当窗口中元素和目标要求相同

                if (mlen > right-left) {    // 当前窗口比最小子串要小，则更新
                    mlen = right-left;
                    begin = left;
                }

                // left开始向右滑动，以缩小窗口长度
//                if (tFreq[ss[left]] == 0) {     // 如果left指向的元素不在目标中，则忽略，直接left++
//                    left++;
//                    continue;
//                }
                if (winFreq[ss[left]] == tFreq[ss[left]]) {     // left指向的元素在目标中，distance--
                    distance--;
                }
                winFreq[ss[left]]--;    // 减去窗口中的此元素
                left++;
            }
        }

        if (mlen == slen + 1) return "";    // 如果mlen == slen+1，则表示整个数组都凑不出目标
        return s.substring(begin, begin+mlen);
    }
}
