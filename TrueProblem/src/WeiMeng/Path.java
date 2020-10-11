package WeiMeng;

/**
 * @author zhuqiu
 * @date 2020/9/6
 */
public class Path {

    public static void main(String[] args) {
        String a = "/qihoo/app/a/b/c/d/new.c";
        String b = "/qihoo/app/1/2/test.c";
        String path = new Path().getPath(a, b);
        System.out.println(path);
    }

    public String getPath(String a, String b) {
        String[] as = a.split("/");
        String[] bs = b.split("/");

        int mark = -1;
        for (int i = 0; i < b.length(); i++) {
            if (!as[i].equals(bs[i])) {
                mark = i - 1;
                break;
            }
        }

        int i = as.length - 2;
        StringBuilder sb = new StringBuilder();

        while (!as[i--].equals(bs[mark])) {
            sb.append("../");
        }
        i += 2;

        while (i < bs.length) {
            sb.append(bs[i++] + "/");
        }
        return sb.toString();
    }
}
