package Tree;

import java.util.ArrayList;

/**
 * @author zhuqiu
 * @date 2020/3/22
 */
public class VerifyArray {

    public static void main(String[] args) {
        VerifyArray instance = new VerifyArray();
        int[] arr = {4, 6, 7, 5};
        boolean b = instance.VerifySquenceOfBST(arr);
        System.out.println(b);
    }

    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int len = sequence.length;
        int root = sequence[len - 1];
        int[] left = null, right = null;
        int cap = -1;
        for (int i = 0; i < len - 1; i++) {
            if (sequence[i] > root && cap == -1) {
                left = new int[i];
                right = new int[len - i - 1];
                cap = i;
                continue;
            }
            if (cap != -1 && sequence[i] < root) {
                return false;
            }
        }
        if (cap == -1) {
            left = new int[len - 1];
            cap = len - 1;
        }
        for (int i = 0; i < len - 1; i++) {
            if (i < cap) {
                left[i] = sequence[i];
                continue;
            }
            if (right != null) {
                right[i - cap] = sequence[i];
            }
        }
        if (left == null || left.length == 0) {
            return VerifySequenceOfBST(right);
        } else if (right == null || right.length == 0) {
            return VerifySequenceOfBST(left);
        } else {
            return VerifySequenceOfBST(left) && VerifySequenceOfBST(right);
        }

    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return ju(sequence, 0, sequence.length-1);
    }

    public boolean ju(int[]sequence, int start, int len) {
        if (start >= len) {
            return true;
        }
        int i = len;
        while (i>start && sequence[i-1] > sequence[len]){
            i--;
        }
        for (int j = 0; j < i; j++) {
            if (sequence[j] > sequence[len]) {
                return false;
            }
        }
        return ju(sequence, 0, i-1) && ju(sequence, i, len-1);
    }
}
