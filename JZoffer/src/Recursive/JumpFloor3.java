package Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/9/23
 */
public class JumpFloor3 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new JumpFloor3().jumpLog(10);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    List<List<Integer>> res;

    public List<List<Integer>> jumpLog(int floor) {
        res = new ArrayList<>();
        record(floor, new LinkedList<>());
        return res;
    }

    public void record(int floor, LinkedList<Integer> temp) {
        if (floor == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }else if (floor < 2) {
            return;
        } else if (floor == 2){
            temp.addFirst(2);
            res.add(new ArrayList<>(temp));
        } else {
            temp.addFirst(2);
            record(floor-2, new LinkedList<>(temp));
            temp.removeFirst();

            temp.addFirst(3);
            record(floor-3, new LinkedList<>(temp));
        }
    }
}
