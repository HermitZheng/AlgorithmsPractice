package syntax.IO;

import java.io.*;

/**
 * 字符流和字节流都是计算机和硬盘之间发生的io操作
 * 基于硬盘的读写操作相对较慢，速度受到硬盘读写速度制约
 * 为了提高读写速度，一定程度上绕过硬盘的限制，提供缓冲流
 * 缓冲流先把数据缓存进内存，在内存中进行io操作
 *
 */
public class BufferStreamTest {

    public static void main(String[] args) throws IOException {
        String inPath = "D:/JavaPractice/src/syntax/IO/test/text1.txt";
        testBufferInput(inPath);
        String outPath = "D:/JavaPractice/src/syntax/IO/test/BufferStream_out.txt";
        String text = "buffer output";
        testBufferOutput(outPath, text);

    }

    public static void testBufferInput(String inPath) throws IOException {
        FileInputStream in = new FileInputStream(inPath);
        BufferedInputStream bis = new BufferedInputStream(in);

        byte[] b = new byte[10];
        int len = 0;
        while ((len = bis.read(b)) != -1){
            System.out.println(new String(b, 0, len));
        }
        bis.close();
        in.close();
    }

    public static void testBufferOutput(String outPath, String text) throws IOException {
        FileOutputStream out = new FileOutputStream(outPath);
        BufferedOutputStream bos = new BufferedOutputStream(out);

        bos.write(text.getBytes());
        bos.flush();
        bos.close();
        out.close();
    }

    public static void copyBufferStream() {

    }
}
