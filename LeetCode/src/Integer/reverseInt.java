package Integer;

/**
 * @author zhuqiu
 * @date 2020/5/1
 */
public class reverseInt {

    public static void main(String[] args) {
        int res = new reverseInt().reverse(123);
        System.out.println(res);
    }

    public int reverse(int x) {
        String string = Integer.toString(x);
        int flag = 1;
        if(x < 0) {
            flag = -1;
            string = string.substring(1);
        }
        try{
            return Integer.valueOf(new StringBuilder(string).reverse().toString()) * flag;
        } catch(Exception e) {
            return 0;
        }
    }
}
