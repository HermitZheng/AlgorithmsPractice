package SomeClass;

/**
 * @author zhuqiu
 * @date 2020/3/25
 */
public abstract class People {

    private String name;
    private String address;
    private int age;

    public People(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public People() {
    }

    public void yourName(){
        System.out.println("My name is:"+ name);
    }

    public abstract void whoAreYou();
}

class Student extends People {

    private static int grade = 5;

    public static void main(String[] args) {
//        Student student = new Student();
    }

    public Student(int grade) {
//        super();
        this.grade = grade;
    }

    public Student() {
        System.out.println("construct");
    }

    static {
        System.out.println(grade);
        grade = 10;
        System.out.println(grade);
    }

    {   //  构造代码块
        grade = 10;
        System.out.println(grade);
    }
    {
        grade = 20;
        System.out.println(grade);

    }

    public Student(String name, String address, int age) {
        super(name, address, age);
    }

    @Override
    public void yourName() {
        super.yourName();
        System.out.printf("My grade is %d.\n", grade);
    }

    @Override
    public void whoAreYou() {
        System.out.println("I am a student.");
    }
}
