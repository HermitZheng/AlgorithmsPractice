package syntax.IO;

import java.io.*;

public class ObjectStreamTest {

    public static void main(String[] args) throws Exception {
        String outPath = "D:/JavaPractice/src/syntax/IO/test/obj_out.txt" ;
        testSerialize(outPath);
        String inPath = "D:/JavaPractice/src/syntax/IO/test/obj_out.txt" ;
        testDeserialize(inPath);
    }

    /**
     * 对象的序列化
     */
    public static void testSerialize(String outPath) throws IOException {
        /**
         * 定义对象的输出流，把对象序列化之后的流放到指定的文件中
         */
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outPath));
        Person p = new Person();
        p.setAge(11);
        p.setName("fole");

        out.writeObject(p);
        out.flush();
        out.close();

    }

    /**
     * 序列化和反序列化使用的类要严格一致，包名、类名、类结构等都要一致
     *
     */
    public static void testDeserialize(String inPath) throws Exception {
        // 创建对象输入流对象，从指定文件中将对象反序列化后的流读取出来
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(inPath));
        Person p;
        p = (Person) in.readObject();

        System.out.println(p.getAge() + p.getName());

    }
}
