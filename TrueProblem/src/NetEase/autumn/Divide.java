package NetEase.autumn;

import java.util.*;

/**
 * @author zhuqiu
 * @date 2020/8/8
 */
public class Divide {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i=0; i<T; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j=0; j<n; j++) {
                arr[j] = in.nextInt();
            }
            int res = method(arr);
            System.out.println(res);
        }
    }

    public static int method(int[] arr) {
        Arrays.sort(arr);
        // a >= b
        int a = 0, b = 0, waste = 0;
        Map<Integer, Integer> mapa = new HashMap<>();
        Map<Integer, Integer> mapb = new HashMap<>();

        for (int i = arr.length-1; i >=0; i--) {
            if (i == 0) {
                b += arr[i];
                mapb.put(arr[i], mapb.getOrDefault(arr[i], 0) + 1);
                break;
            }
            if (a <= b) {
                a += arr[i];
                mapa.put(arr[i], mapa.getOrDefault(arr[i], 0) + 1);
                i--;
                b += arr[i];
                mapb.put(arr[i], mapb.getOrDefault(arr[i], 0) + 1);
            } else {
                b += arr[i];
                mapb.put(arr[i], mapb.getOrDefault(arr[i], 0) + 1);
                i--;
                a += arr[i];
                mapa.put(arr[i], mapa.getOrDefault(arr[i], 0) + 1);
            }
        }
        if (a == b) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (a == b) {
                return waste;
            }
            int item = arr[i];
//            if (a > b) {
                if (mapa.containsKey(item) && mapa.get(item) > 0) {
                    a -= item;
                    waste += item;
                    mapa.put(item, mapa.get(item)-1);
                } else {
                    b -= item;
                    waste += item;
                    mapb.put(item, mapb.get(item)-1);
                }
//            } else if (b > a) {
//                if (mapb.containsKey(item) && mapb.get(item) > 0) {
//                    b -= item;
//                    waste += item;
//                    mapb.put(item, mapb.get(item)-1);
//                } else {
//                    a -= item;
//                    waste += item;
//                    mapa.put(item, mapa.get(item)-1);
//                }
//            }
        }
        return waste;
    }



    public static void method__(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2-o1);
        int sum = 0;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            sum += i;
        }
        Arrays.sort(arr);
        int waste = 0, mod;
        if ((mod = Math.floorMod(sum, 2)) != 0) {
            if (map.containsKey(mod)) {
                waste += mod;
                sum -= mod;
                System.out.println(waste);
                return;
            }
            for (int i : arr) {
                sum -= i;
                waste += i;
                if (Math.floorMod(sum, 2) == 0) {
                    System.out.println(waste);
                    return;
                }
            }

        }
    }


}
