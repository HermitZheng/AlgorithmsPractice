package syntax.IO;

import java.io.*;

/**
 * 编码格式txt和java：
 * ISO8859-1 西欧编码，纯粹英文编码
 * GBK、UFT-8 使用中英文
 * 一般使用UTF-8
 */
public class StreamRWterTest {
    /**
     * 当字节流中的数据都是字符时，转换为字符流会更高效
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String inPath = "D:/JavaPractice/src/syntax/IO/test/text1.txt";
        testInputStreamReader(inPath);
    }

    public static void testInputStreamReader(String inPath) throws IOException {
        FileInputStream fis = new FileInputStream(inPath);
        // 把字节流转为字符流,设置的字符编码要和文件一致
//        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");


        char[] c = new char[100];
        int len =0;
        while ((len = isr.read(c)) != -1){
            System.out.println(new String(c, 0, len));
        }

    }
}
