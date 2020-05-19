package syntax.IO;

import java.io.File;

/**
 * 使用递归，遍历test下所有文件
 */
public class dirTest {
    public void iterFile(File file){
        // 要用递归
        if(file.isFile()){
            System.out.println(file.getAbsolutePath() + "是文件");
        }else {
            System.out.println(file.getAbsolutePath() + "是文件夹");
            // 有子文件夹或文件
            File[] listFiles = file.listFiles();
            if(listFiles != null && listFiles.length > 0) {
                for (File ff : listFiles) {
                    iterFile(ff); // 递归
                }
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("D:/JavaPractice/src/syntax/IO/test");
        new dirTest().iterFile(f);
    }
}
