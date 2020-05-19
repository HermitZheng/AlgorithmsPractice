package syntax.IO;

import java.io.*;

public class SystemINTest {
    public static void main(String[] args) throws IOException {
//        testSystemIn();
        String outPath = "D:/JavaPractice/src/syntax/IO/test/Sysin_writer.txt";
        testSystemInWrite(outPath);
    }

    public static void testSystemIn() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(is);

        String str = "";
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
        is.close();
    }

    public static void testSystemInWrite(String outPath) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        String line = "";

        BufferedWriter bw = new BufferedWriter(new FileWriter(outPath));
        while ((line = br.readLine()) != null){
            if (line.equals("over")){
                break;
            }
            bw.write(line);
        }
        bw.flush();
        bw.close();
        br.close();
        is.close();
    }
}
