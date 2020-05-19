package syntax.Concurrent;

public class Test3 {
    public static void main(String[] args) {
        Account a = new Account();
        Account a1 = new Account();

        User u_wx = new User(a, 2000);
        User u_zfb = new User(a, 2000);

        Thread wx = new Thread(u_wx, "微信");
        Thread zfb = new Thread(u_zfb, "支付宝");

        wx.start();
        zfb.start();
    }
}

class Account {
    public static int money = 3000;

    /**
     * 判断账户钱够不够
     * 共享资源时，一个线程还没有执行完毕，另一个线程也开始执行方法
     * 解决方法：让一个线程整体执行完毕，另一个线程在开始执行
     * 通过synchronize同步锁来完成
     * 在方法上加上synchronize关键字
     * 再普通方法上加同步锁，锁的是整个类，而不是一个方法
     * 不同的对象就是不同的锁
     * 普通方法加synchronize，线程使用不同的此方法的对象，还是共享资源
     * @param m
     */
    public synchronized void drawing1(int m){
        String name = Thread.currentThread().getName();
        if (money < m){
            System.out.println(name + "操作，账户金额不足：" + money);
        }else{
            System.out.println(name + "账户原有金额" + money);
            System.out.println(name + "取款金额" + m);
            System.out.println(name + "取款操作：" + money + "-" + m);

            money -= m;
            System.out.println(name + "账户剩余金额" + money);
        }
    }
    /**
     * 静态方法加一个synchronize，对于所有的对象都是同一个锁
     */
    public static synchronized void drawing2(int m){
        String name = Thread.currentThread().getName();
        if (money < m){
            System.out.println(name + "操作，账户金额不足：" + money);
        }else{
            System.out.println(name + "账户原有金额" + money);
            System.out.println(name + "取款金额" + m);
            System.out.println(name + "取款操作：" + money + "-" + m);

            money -= m;
            System.out.println(name + "账户剩余金额" + money);
        }
    }

    /**
     * 对代码块加入synchronize锁
     * @param m
     */
    public synchronized void drawing3(int m){
        synchronized (this){
            // 用this锁代码块，代表当前对象
            // 如果在其他方法中也有synchronize代码块使用的都是同一个同步锁
            String name = Thread.currentThread().getName();
            if (money < m){
                System.out.println(name + "操作，账户金额不足：" + money);
            }else{
                System.out.println(name + "账户原有金额" + money);
                System.out.println(name + "取款金额" + m);
                System.out.println(name + "取款操作：" + money + "-" + m);

                money -= m;
                System.out.println(name + "账户剩余金额" + money);
            }}
    }
    public synchronized void drawing4(int m){
        synchronized (this){
            // 用this锁代码块，代表当前对象
            // 如果在其他方法中也有synchronize代码块使用的都是同一个同步锁
            String name = Thread.currentThread().getName();
            if (money < m){
                System.out.println(name + "操作，账户金额不足：" + money);
            }else{
                System.out.println(name + "账户原有金额" + money);
                System.out.println(name + "取款金额" + m);
                System.out.println(name + "取款操作：" + money + "-" + m);

                money -= m;
                System.out.println(name + "账户剩余金额" + money);
            }}
    }

    /**
     * synchronize代码块，想要根据不同的对象有不同的锁
     * @param m
     */
    public synchronized void drawing5(int m, Account a){
        synchronized (a){ // 通过方法的参数传递进来的对象的代码块被加了同步锁
            // 不同的对象有不同的同步锁
            String name = Thread.currentThread().getName();

            if (name.equals("微信")){
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (money < m){
                System.out.println(name + "操作，账户金额不足：" + money);
            }else{
                System.out.println(name + "账户原有金额" + money);
                System.out.println(name + "取款金额" + m);
                System.out.println(name + "取款操作：" + money + "-" + m);

                money -= m;
                System.out.println(name + "账户剩余金额" + money);
            }
            if (name.equals("支付宝")){
                try {
                    a.notify();
//                    a.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class User implements Runnable{
    Account account;
    int money;

    public User(Account account, int money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
//        account.drawing1(money);

//        if (Thread.currentThread().getName() == "微信"){
////            account.drawing1(money);
//            account.drawing3(money);
//        }else{
////            account.drawing1(money);
//            account.drawing4(money);
//        }
//        account.drawing2(money);
//        account.drawing3(money);
        account.drawing5(money, account);

    }
}