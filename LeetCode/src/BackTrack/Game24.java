package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/9/13
 */
public class Game24 {

    public static void main(String[] args) {
        int[] list = {8, 1, 6, 6};
        boolean b = new Game24().judgePoint24(list);

        System.out.println(b);
    }

    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1;
    static final int SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();
                    // 把未选中运算的数，加入到list中
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        // 剪枝，加和乘交换了位置也一样
                        if (k < 2 && i > j) {
                            continue;
                        }
                        switch (k) {
                            case ADD:
                                list2.add(list.get(i) + list.get(j));
                                break;
                            case MULTIPLY:
                                list2.add(list.get(i) * list.get(j));
                                break;
                            case SUBTRACT:
                                list2.add(list.get(i) - list.get(j));
                                break;
                            case DIVIDE:
                                // 除数小于零
                                if (Math.abs(list.get(j)) < EPSILON) {
                                    continue;
                                } else {
                                    list2.add(list.get(i) / list.get(j));
                                }
                                break;
                            default:
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        // 回溯
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

}
