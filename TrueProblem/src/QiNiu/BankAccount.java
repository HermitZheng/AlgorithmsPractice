package QiNiu;

/**
 * @author zhuqiu
 * @date 2020/4/28
 */
public class BankAccount {
    private long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    static void transferFrom(BankAccount source, BankAccount dest, long amount) {
        synchronized (BankAccount.class) {
            source.balance -= amount;
            dest.balance += amount;
        }
    }

    public synchronized long balance() {
        return balance;
    }
//        工程师小明，考虑到这样的实现对性能不太友好，于是重构了一版transferFrom方法：
    static void transferFrom_2(BankAccount source,BankAccount dest,long amount){
        synchronized(source){
            synchronized(dest){
                source.balance -= amount;
                dest.balance += amount;
            }
        }
    }
}

