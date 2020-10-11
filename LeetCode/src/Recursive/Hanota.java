package Recursive;

import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/9/24
 */
public class Hanota {

    /**
     * 将 A 上的所有盘子，借助 B，移动到C 上
     * @param A 原柱子
     * @param B 辅助柱子
     * @param C 目标柱子
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    private void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
        if (num == 1) {    // 只剩一个盘子时，直接移动即可
            target.add(original.remove(original.size() - 1));
            return;
        }

        movePlate(num - 1, original, target, auxiliary);   // 将 size-1 个盘子，从 original 移动到 auxiliary
        target.add(original.remove(original.size() - 1));   // 将 第size个盘子，从 original 移动到 target
        movePlate(num - 1, auxiliary, original, target);   // 将 size-1 个盘子，从 auxiliary 移动到 target
    }
}
