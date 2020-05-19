import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/3/24
 */
public class Genes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String[] arr1 = new String[s1.length()];
        String[] arr2 = new String[s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            arr1[i] = s1.substring(i, i+1);
            arr2[i] = s2.substring(i, i+1);
        }
        int result = method(arr1, arr2);
        System.out.println(result);

    }

    public static int method(String[] s1, String[] s2){
        if (s1 == null || s2 == null){
            return 0;
        }
        int num1, num2;
        num1 = num2 =0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals("A") && s2[i].equals("T")){
                num1++;
            }
            if (s1[i].equals("T") && s2[i].equals("A")){
                num2++;
            }
        }
        int result = Math.max(num1, num2);
        return result;
    }
}
