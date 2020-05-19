package TimeScope;

/**
 * @author zhuqiu
 * @date 2020/5/17
 */
public class doHomeWork {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int start = startTime[i];
            int end = endTime[i];
            if (start <= queryTime && end >= queryTime) count++;
        }
        return count;
    }
}
