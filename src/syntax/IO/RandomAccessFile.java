package syntax.IO;

public class RandomAccessFile {
    /**
     * 文件的随机读写
     * 可以跳到文件的任意位置来读写
     * @param args
     */
    public static void main(String[] args) {
        String inPath =  "D:/JavaPractice/src/syntax/IO/test/text1.txt";
    }
/*
    public static void testRandomRead(String inPath) {
        // 参数二是访问模式：r,rw,rwd：同步更新,rws：同步更新和源数据
        RandomAccessFile ra = new RandomAccessFile(inPath, "r");

        ra.seek(0); // 读取起始点

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = ra.read(b)) != null){
            System.out.println(new String(b, 0, len));
        }


    }
*/
}

