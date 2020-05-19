package linkedlist;

/**
 * @author zhuqiu
 * @date 2020/2/15
 */
public class Linked {

    public int num;

    public String value;

    public Linked next;

    public Linked(int num, String value) {
        this.num = num;
        this.value = value;
    }

    public Linked(int num) {
        this.num = num;
    }

    public Linked() {
    }

    @Override
    public String toString() {
        return "Linked{" +
                "num=" + num +
                ", value='" + value +
                '}';
    }

    public void addNode(Linked node){
        Linked temp = this;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        System.out.println("添加结点完毕");
    }

    public void show(){
        if (this.next == null){
            System.out.println("链表为空");
        }
        System.out.println("开始遍历");
        Linked temp = this.next;
        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
        System.out.println("结束遍历");
    }

}
