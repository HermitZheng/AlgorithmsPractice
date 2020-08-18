import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/5/1
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), V = in.nextInt();
        int[] weight = new int[N];
        int[] value = new int[N];
        for (int i = 0; i<N; i++) {
            value[i] = in.nextInt();
            weight[i] = in.nextInt();
        }
        // 代表装载第[i]件物品时，占用的容量为[j]，此时的背包价值
        int[][] dp = new int[N+1][V+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N-1][V]);
    }

    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        for (int i=1; i<salary.length-1; i++) {
            sum += salary[i];
        }
        return (double) sum / (salary.length - 2) * 1.0;
    }

    public boolean isPathCrossing(String path) {
        Stack<Integer> stack = new Stack<>();
        int x = 0, y = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> temp = new HashSet<>();
        temp.add(0);
        map.put(0, temp);

        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) == 'N') {
                y++;
            } else if(path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
            Set<Integer> set = map.getOrDefault(x, new HashSet<>());
            if (set.contains(y)) return true;
            set.add(y);
            map.put(x, set);
        }
        return false;
    }



}
