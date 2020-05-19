package syntax.Concurrent;

/**
 * 生产者与消费者
 */
public class Productor_Customer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        // 消费时不生产，生产时不消费
        // 生产者
        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (clerk){
                    while(true){
                        if (clerk.productNum == 0){
                            System.out.println("产品数为0，开始生产");
                            while (clerk.productNum < 4){
                                clerk.productNum++; // 增加产品
                                System.out.println("库存" + clerk.productNum);
                            }
                            System.out.println("产品数为" + clerk.productNum + "结束生产");
                            clerk.notify();  // 唤醒消费者线程
                        }else {
                            try {
                                clerk.wait();  // 生产者线程等待
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        }, "生产者").start();
        // 消费者
        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (clerk){
                    while(true){
                        if (clerk.productNum == 4){
                            System.out.println("产品数为4，开始消费");
                            while (clerk.productNum > 0){
                                clerk.productNum--; // 消费产品
                                System.out.println("库存" + clerk.productNum);
                            }
                            System.out.println("产品数为" + clerk.productNum + "结束消费");
                            clerk.notify();  // 唤醒生产者线程
                        }else {
                            try {
                                clerk.wait();  // 消费者线程等待
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "消费者").start();

    }

}

class Clerk {
    public int productNum = 0;
}
