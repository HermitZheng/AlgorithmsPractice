package linkedlist;

/**
 * @author zhuqiu
 * @date 2020/2/15
 */
public class Merge {

    private static Linked lista = new Linked(0);
    private static Linked listb = new Linked(0);

    public static void main(String[] args) {
        lista.addNode(new Linked(2));
        lista.addNode(new Linked(5));

        listb.addNode(new Linked(3));
        listb.addNode(new Linked(4));

        lista.show();
        listb.show();

        System.out.println(lista.next.num);

        Linked merge = merge(lista, listb);

        merge.show();

    }

    public static Linked merge(Linked lista, Linked listb){

        Linked resultList = new Linked(0);

        if (lista.next == null && listb.next == null){
            System.out.println("链表都为空！");
            throw new RuntimeException();
        }

        if (lista.next == null){
            System.out.println("A链表为空");
            return listb;

        } else if (listb.next == null){
            System.out.println("B链表为空");
            return lista;
        }

        Linked temp = resultList;
        lista = lista.next;
        listb = listb.next;

        while (lista != null && listb != null){
            if (lista.num <= listb.num) {
//                temp.addNode(lista);
                temp.next = lista;
                lista = lista.next;
                temp = temp.next;
                continue;
            }
            if (lista.num > listb.num) {
//                temp.addNode(listb);
                temp.next = listb;
                listb = listb.next;
                temp = temp.next;
                continue;
            }
            temp.show();
        }
        if (lista == null) {
            temp.next = listb;
        }
        if (listb == null) {
            temp.next = lista;
        }

        return resultList;
    }



}
