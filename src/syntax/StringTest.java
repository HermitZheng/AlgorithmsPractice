package syntax;

public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3 == s4);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        String s5 = s3;
        System.out.println(s5 == s3 && s3 == s4);
    }

}
