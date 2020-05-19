package example.RedPacket;

import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        /*
        第一次发红包金额0.01~6.66元
        第二次发红包金额0.01~3.34元(取不到尾，剩下0.01）
        1 + random.nextInt(left / leftcount * 2)
         */
        Random r = new Random();
        int leftMoney = totalMoney;
        int leftCount = totalCount;

        for (int i = 0; i < totalCount - 1; i++) {
            int money = r.nextInt(leftMoney / leftCount * 2) + 1;
            list.add(money);
            leftMoney -= money;
            leftCount--;
        }
        list.add(leftMoney);

        return list;
    }
}
