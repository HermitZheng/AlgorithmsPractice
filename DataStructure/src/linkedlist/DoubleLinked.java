package linkedlist;

/**
 * @author zhuqiu
 * @date 2020/2/16
 */
public class DoubleLinked {


    public int num;

    public String value;

    public DoubleLinked next;

    public DoubleLinked pre;

    public DoubleLinked(int num, String value) {
        this.num = num;
        this.value = value;
    }

    public DoubleLinked(int num) {
        this.num = num;
    }

    public DoubleLinked() {
    }

    @Override
    public String toString() {
        return "DoubleLinked{" +
                "num=" + num +
                ", value='" + value +
                '}';
    }

    public void addNode(DoubleLinked node){
        DoubleLinked temp = this;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
        System.out.println("添加结点完毕");
    }

    public void show(){
        if (this.next == null){
            System.out.println("链表为空");
        }
        System.out.println("开始遍历");
        DoubleLinked temp = this.next;
        while (temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
        System.out.println("结束遍历");
    }


}
