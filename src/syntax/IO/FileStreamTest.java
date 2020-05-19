package syntax.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
    /**
     * 文件字节流非常通用，可以操作字符的文档，还可以操作任何类型文件
     * 因为字节流直接使用二进制
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String inPath = "D:/JavaPractice/src/syntax/IO/test/text1.txt";
        String outPath = "D:/JavaPractice/src/syntax/IO/test/text_copy.txt";
        testInputStream(inPath);
        testOutputStream();
        copyFile(inPath, outPath);
    }
    public static void testInputStream(String inPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inPath);

        byte[] b = new byte[10]; // 设置一个byte数组，接受读取文件的内容
        int len = 0; // 设置一个读取数据的长度
//        fileInputStream.read(b); // 有一个返回值是读取的数据的长度
        // 如果读到最后一个数据，还会向后读一个，返回一个-1
        // 当返回值是-1时，整个文件就读取完毕了
        while ((len = fileInputStream.read(b)) != -1){
            System.out.println(new String(b, 0, len));
            // 参数一：缓冲数据的数组， 参数二：从数组的那个位置开始转化字符串
            // 参数三：总共转化几个字节
        }
        System.out.println(new String(b));

        fileInputStream.close();
    }

    public static void testOutputStream() {
        try {
            FileOutputStream out  = new FileOutputStream("D:/JavaPractice/src/syntax/IO/test/text2.txt");
            String str = "shide,wofole";
            out.write(str.getBytes()); // 把数据写到内存
            out.flush(); // 吧内存中的数据刷写到硬盘
            out.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void copyFile(String inParh, String outPath) {
        try {
            // 读取的源文件
            FileInputStream in = new FileInputStream(inParh);
            // 复制的目的路径
            FileOutputStream out  = new FileOutputStream(outPath);
            byte[] b = new byte[100];
            int len = 0;
            while((len = in.read(b)) != -1){
                out.write(b, 0, len);
            }
            out.flush();
            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
