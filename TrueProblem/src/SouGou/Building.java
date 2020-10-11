package SouGou;

/**
 * @author zhuqiu
 * @date 2020/9/5
 */
public class Building {

    public static void main(String[] args) {
        int t = 2;
        int[] list = {-1,4,5,2};
        int res = new Building().getHouses(t, list);

        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能创建的房屋数
     *
     * @param t  int整型 要建的房屋面宽
     * @param xa int整型一维数组 已有房屋的值，其中 x0 a0 x1 a1 x2 a2 ... xi ai 就是所有房屋的坐标和房屋面宽。 其中坐标是有序的（由小到大）
     * @return int整型
     */
    public int getHouses(int t, int[] xa) {
        // write code here
        int sum = 2, count = xa.length;
        int preP = xa[0], preL = xa[1];
        for (int i = 2; i < count; i += 2) {
            int pos = xa[i], len = xa[i + 1];

            double dis = (pos - preP) - (preL / 2.0 + len / 2.0);

            if (dis == t) {
                sum++;
            } else if (dis > t) {
                sum += 2;
            }

            preP = pos;
            preL = len;
        }
        return sum;
    }
}
