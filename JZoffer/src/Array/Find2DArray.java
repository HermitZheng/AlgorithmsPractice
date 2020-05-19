package Array;

/**
 * @author zhuqiu
 * @date 2020/3/10
 */
public class Find2DArray {

    public boolean Find(int target, int [][] array) {
        Integer len2 = array[0].length;
        if (len2 == 0){       // 空的二维数组，第一层的长度仍旧为1，应该由其第二维的长度来判断是否为空
            return false;
        }
        Integer len1 = array.length;
        if (array[0][0] > target || array[len1-1][len2-1] < target){   // 先判断是否超出二维数组的最大最小值
            return false;
        }

        for (int i = 0; i < len1; i++) {
            int[] inner = array[i];
            if (inner[len2-1] < target){
                continue;
            }else {
                for (int j = 0; j < len2; j++) {
                    if (inner[j] == target){
                        return true;
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] array2D = {{1, 2, 3},
                            {2, 3, 4},
                            {3, 4, 5}};
        int [][] nullArray = {{}};
        Find2DArray Find = new Find2DArray();
        boolean res = Find.Find(6, nullArray);
        System.out.println(res);
    }
}
