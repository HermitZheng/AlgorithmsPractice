package Link;

import java.util.ArrayList;

public class ReverseArray {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode temp = listNode;
        while (temp != null){
            arrayList.add(0, temp.val);
            temp = temp.next;
        }
        System.out.println(arrayList);
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
//        while (listNode != null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ReverseArray reverse = new ReverseArray();
        ArrayList<Integer> arrayList = reverse.printListFromTailToHead(listNode);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }
}
