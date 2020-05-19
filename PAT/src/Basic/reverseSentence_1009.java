package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/5/5
 */
public class reverseSentence_1009 {

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String[] list = in.nextLine().split(" ");
        for (int i=list.length-1; i>=0; i--) {
            if (i < list.length-1) System.out.print(" ");
            System.out.print(list[i]);
        }
    }
}
