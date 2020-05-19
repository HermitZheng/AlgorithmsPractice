package example.RedPacket;

/*
红包分发的策略：
    1.普通红包（平均）：totalMoney / totalCount, 余数放在最后一个红包里
    2.随机红包（随机）：最少一分钱，最多不超过平均数的二倍
 */
public class Bootstrap {

    public static void main(String[] args) {
        MyRed red = new MyRed("test");

        red.setName("shide");

        // 普通红包
        OpenMode normal = new NomalMode();
        OpenMode random = new RandomMode();
        red.setMoney(1);

    }

}
