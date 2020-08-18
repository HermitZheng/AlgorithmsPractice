package Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuqiu
 * @date 2020/6/21
 */
public class FolderNames {

    public static void main(String[] args) {
        String[] names = {"kaido","kaido(2)","kaido","kaido(1)"};
        String[] folderNames = new FolderNames().getFolderNames(names);
        for (String folderName : folderNames) {
            System.out.println(folderName);
        }
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int len = names.length;
        String[] res = new String[len];

        for (int i = 0; i < len; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                res[i] = name;
                int j = 0;
                for (; j < name.length(); j++) {
                    if (name.charAt(j) != '(') continue;
                    break;
                }
                String pureName = name.substring(0, j);
                map.put(name, 0);
                if (!name.equals(pureName)) {
                    map.put(pureName, map.getOrDefault(pureName, -1)+1);
                }
            } else {
                int num = map.get(name) + 1;
                while (map.containsKey(name + "(" + num + ")")) {
                    num++;
                }
                String newName = name + "(" + num + ")";
                res[i] = newName;
                map.put(name, map.get(name)+1);
                map.put(newName, 0);
            }
        }
        return res;
    }

    public String[] get(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                int num = map.get(names[i]) + 1;
                while (set.contains(names[i] + "(" + num + ")")) {
                    num++;
                }
                map.put(names[i], num);
                map.put(names[i] + "(" + num + ")", 0);
                res[i] = names[i] + "(" + num + ")";
            } else {
                res[i] = names[i];
                map.put(names[i], 0);
            }
            set.add(res[i]);
        }
        return res;
    }
}
