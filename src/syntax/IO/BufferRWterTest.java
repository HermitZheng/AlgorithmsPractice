package syntax.IO;

import java.io.*;

public class BufferRWterTest {

    public static void main(String[] args) throws IOException {
        String inPath = "D:/JavaPractice/src/syntax/IO/test/text1.txt";
        testBufferReader(inPath);
        String outPath = "D:/JavaPractice/src/syntax/IO/test/bufferRW_copy.txt";
        copyFile(inPath, outPath);
    }

    public static void testBufferReader(String inPath) throws IOException {

        FileReader fr = new FileReader(inPath);
        BufferedReader br = new BufferedReader(fr);

        char[] c = new char[100];
        int len = 0;

        while ((len = br.read(c)) != -1){
            System.out.println(new String(c, 0, len));
        }
        br.close();
        fr.close();
     }

     public static void copyFile(String inPath, String outPath) throws IOException {
//        FileReader fr = new FileReader(inPath);
        BufferedReader br = new BufferedReader(new FileReader(inPath));
//        FileWriter fw = new FileWriter(outPath);
        BufferedWriter bw = new BufferedWriter(new FileWriter(outPath));

        char[] c = new char[10];
        int len = 0;
        while((len = br.read(c)) != -1){
            bw.write(c, 0, len);
        }
        bw.flush();
        bw.close();
//        fw.close();
        br.close();
//        fr.close();
     }
}
