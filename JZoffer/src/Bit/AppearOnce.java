package Bit;

/**
 * @author zhuqiu
 * @date 2020/4/4
 */
public class AppearOnce {

    public static void main(String[] args) {
        int[] array = {3, 1, 2};
        int[] num1 = new int[1], num2 = new int[1];
        new AppearOnce().FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);

    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        if (len == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int result = 0;                     // 任何数与0异或，结果都为那个数本身
        for (int i = 0; i < len; i++) {     // 对整个数组做异或运算，留下来两个不同的数A^B  （两个相同的数异或为0）
            result ^= array[i];
        }
        int firstBit = findFirstBit1(result);
        for (int i = 0; i < len; i++) {
            if (isBit1or0(array[i], firstBit)) {    // 对于两个不同的组，分别进行组内异或运算，留下来的为组内单独的数
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    public int findFirstBit1(int result) {      // 寻找result中第一个为1的位置，即A与B不同的位置
        int index = 0;
        while ((result & 1) == 0 && index<32){
            result >>= 1;
            index++;
        }
        return index;
    }

    public boolean isBit1or0(int arrayEle, int firstBit) {   // 利用A与B不同的这个位置，将整个数组分为两组，A和B分别在不同组里
        return ((arrayEle >> firstBit) & 1) == 1;            // 同时，相同的两个数必定在同一个组里
    }
}
