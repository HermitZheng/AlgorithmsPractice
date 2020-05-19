package Bit;

/**
 * @author zhuqiu
 * @date 2020/3/22
 */
public class BinaryNumbers {

    public static void main(String[] args) {
        BinaryNumbers instance = new BinaryNumbers();
        int i = instance.NumberOf1(4);
        System.out.println(i);
    }

    public int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1'){
                num++;
            }
        }
        return num;
    }
}
