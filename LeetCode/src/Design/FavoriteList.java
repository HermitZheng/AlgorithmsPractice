package Design;

import java.util.*;

/**
 * leetcode 5414
 *
 * @author zhuqiu
 * @date 2020/5/17
 */
public class FavoriteList {

    public static void main(String[] args) {
//        new FavoriteList().peopleIndexes()
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int len = favoriteCompanies.size();
        List<Integer> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<String> list = favoriteCompanies.get(i);
            for (String s : list) {     // 对于每一个公司，map中保存所有收藏这个公司的用户列表
                map.computeIfAbsent(s, k -> new ArrayList<>()).add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            int[] bucket = new int[len];    // 每个用户一个桶
            List<String> userFavoriteList = favoriteCompanies.get(i);   // 当前用户收藏列表
            for (String companyName : userFavoriteList) {
                List<Integer> userList = map.get(companyName);  // 收藏这个公司的用户列表
                for (Integer id : userList) {
                    bucket[id]++;       // 对于自己收藏的公司，如果其他用户也收藏了，那么就在其他用户的位置+1
                }
            }
            bucket[i] = 0;  // 自己的不算
            int max = Arrays.stream(bucket).max().getAsInt();   // 其他用户和自己收藏的重复度
            if (!(max == userFavoriteList.size())) res.add(i);  // 如果和自己完全重复，则为子集
        }
        return res;
    }

    public List<Integer> peopleIndexes_api(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int len = favoriteCompanies.size();
        Map<List<String>, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(favoriteCompanies.get(i), i);
        }
        Collections.sort(favoriteCompanies, Comparator.comparingInt(value -> value.size()));

        for (int i = 0; i < len; i++) {
            List<String> companyList = favoriteCompanies.get(i);
            boolean flag = false;
            outer:
            for (int j = len-1; j >= 0; j--) {
                if (i == j) continue;
                List<String> others = favoriteCompanies.get(j);
                if (companyList.size() > others.size()) continue;
                if (others.containsAll(companyList)) {
                    flag = true;
                    break outer;
                }
            }
            if (!flag) res.add(map.get(companyList));
        }
        Collections.sort(res);
        return res;
    }
}
