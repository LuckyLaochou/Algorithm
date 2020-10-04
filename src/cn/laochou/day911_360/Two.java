package cn.laochou.day911_360;

import java.util.*;

public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[m];
            int[] b = new int[m];
            for(int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
            }
            getNumber(n, m, a, b);
        }
    }


    private static int getNumber(int n, int m, int[] a, int[] b) {
        // 先统计上班人数和下班人数
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            List<Integer> temp = map.getOrDefault(b[i], new ArrayList<>());
            temp.add(a[i]);
        }
        // 然后统计
        List<Integer> off = map.get(0);
        List<Integer> up = map.get(1);
        if(off.size() == m) {
            return off.get(off.size() - 1);
        }else {

        }
        return 1;
    }

}
