package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqiu
 * @date 2020/3/10
 */

/**
 * 如果一边遍历一边修改，由于替换字符%20占三个位置
 * 所以会导致字符串长度改变、index也会随着改变
 */
public class BlankReplace {

    public String replaceSpace(StringBuffer str) {
        List<Integer> indexList = new ArrayList<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' '){    // 先把要更改的位置记下来
                indexList.add(i);
//                str.replace(i, i+1, "%20");
            }
        }
        for (int i = indexList.size()-1; i >= 0; i--) {   // 从尾部开始向头部更改
            Integer index = indexList.get(i);
            str.replace(index, index+1, "%20");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("  ");
        BlankReplace replace = new BlankReplace();
        String result = replace.replaceSpace(str);
        System.out.println(result);
    }
}
