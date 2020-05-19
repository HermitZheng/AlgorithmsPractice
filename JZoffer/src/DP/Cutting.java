package DP;

import java.util.Arrays;

/**
 * @author zhuqiu
 * @date 2020/3/30
 */
public class Cutting {

    public static void main(String[] args) {
        int[] data = {1, 5, 8, 9, 10, 17, 17};
        Cutting instance = new Cutting();
        int result = instance.memory(data);
        System.out.println(result);
    }

    public int memory(int[] data) {
        int[] mem = new int[data.length+1];

        Arrays.fill(mem, -1);

        mem[0] = data[0];
        return cut(data, mem, data.length);
    }

    public int cut(int[] data, int[] mem, int len) {
        int result = -1;

        if (mem[len] != -1) {
            return mem[len];
        } else {
            for (int i = 1; i <= len; i++) {
                result = Math.max(result, cut(data, mem, len-i) + mem[i-1]);
            }
        }
        mem[len] = result;
        return result;
    }
}
