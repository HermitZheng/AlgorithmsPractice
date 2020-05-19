package syntax.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWterTest {
    public static void main(String[] args) {
        String inPath = "D:/JavaPractice/src/syntax/IO/test/text1.txt";
        testFileReader(inPath);
        String outPath = "D:/JavaPractice/src/syntax/IO/test/FileWriter.txt";
        testFileWriter(outPath, "nice");
        String copyPath = "D:/JavaPractice/src/syntax/IO/test/RWter_copy.txt";
        copyFile(inPath, copyPath);
    }

    public  static void testFileReader(String inPath) {
        /**
         * 文件字符输入流
         */
        try {
            FileReader fr = new FileReader(inPath);

            char[] c = new char[10];
            int len = 0;
            while ((len = fr.read(c)) != -1){
                System.out.println(new String(c, 0, len));
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFileWriter(String outPath, String text) {
        /**
         * 文件字符输出流
         */
        try {
            FileWriter fw = new FileWriter(outPath);

            fw.write(text); // 写入内存
            fw.flush(); // 写入硬盘
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String inPath, String outPath){
        try {
            FileReader fr = new FileReader(inPath);
            FileWriter fw = new FileWriter(outPath);

            char[] c = new char[100];
            int len = 0;
            while((len = fr.read(c)) != -1) {
                fw.write(c, 0, len);
            }
            fw.flush();
            fw.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
