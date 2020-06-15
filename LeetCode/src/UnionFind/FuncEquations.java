package UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 990
 *
 * @author zhuqiu
 * @date 2020/6/8
 */
public class FuncEquations {

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        /**
         * 对于 == 的元素，将他们合并
         */
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                unionFind.union(x, y);
            }
        }

        /**
         * 对于 != 的元素，如果他们在一个集合里，则为false
         */
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                // 如果x!=y，但是x和y却在一个集合里，则为false
                if (unionFind.isConnected(x, y)) return false;
            }
        }
        return true;
    }


        private class UnionFind {
        private int[] parent;

        public UnionFind(int x) {
            parent = new int[x];
            for (int i = 0; i < x; i++) {
                parent[i] = i;
            }
        }

            /**
             * 找到x最上面的根节点，同时在途中进行路径压缩
             * @param x
             * @return  根节点root
             */
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];  // 路径压缩
                x = parent[x];
            }
            return x;
        }

            /**
             * 找到x和y的根节点，并把它们合并
             * @param x
             * @param y
             */
        public void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            parent[root_x] = root_y;
        }

            /**
             * 判断x和y最终的根节点是否一致，即是否在一个集合里
             * @param x
             * @param y
             * @return boolean
             */
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public boolean equationsPossible_sb(String[] equations) {
        int len = equations.length;
        if (len == 0) return true;

        Map<Character, Boolean> map = new HashMap<>();
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            char bool = equation.charAt(1);
            if (bool == '=') {
                if (map.containsKey(a) && map.containsKey(b)) {
                    if (map.get(a) != map.get(b)) return false;
                    else continue;
                }
                if (map.containsKey(a)) map.put(b, map.get(a));
                else if (map.containsKey(b)) map.put(a, map.get(b));
                else {
                    map.put(a, true);
                    map.put(b, true);
                }
            } else {
                if (a == b) return false;
                if (map.containsKey(a) && map.containsKey(b)) {
                    if (map.get(a) == map.get(b)) return false;
                    else continue;
                }
                if (map.containsKey(a)) map.put(b, !map.get(a));
                else if (map.containsKey(b)) map.put(a, !map.get(b));
                else {
                    map.put(a, true);
                    map.put(b, false);
                }
            }
        }
        return true;
    }
}
