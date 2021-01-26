package concurrent;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhuqiu
 * @date 2021/1/12
 */
public class MyCAS extends Thread {

    private int version;
    private int data;

    @SneakyThrows
    @Override
    public void run() {
        this.data = Data.getData();
        this.version = Data.getVersion();
        System.out.println("准备CAS");
        if (Data.getVersion() == this.version) {
            System.out.println("线程:" + Thread.currentThread().getName() + ", 版本号:" + version + ", data:" + data);

        }
        int[] nums = {1,2,3};
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        FileReader reader = new FileReader(new File(""));
    }
}

class Data {
    static int version = 0;
    static int data = 10000;

    public static int getVersion() {
        return version;
    }

    public static void setVersion(int version) {
        Data.version = version;
    }

    public static int getData() {
        return data;
    }

    public static void setData(int data) {
        Data.data = data;
    }
}
