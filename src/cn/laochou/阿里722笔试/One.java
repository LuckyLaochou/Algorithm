package cn.laochou.阿里722笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/22 0022 9:10
 * @Version: 1.0
 */
public class One {

    public List<int[]> getSeq(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();
        dfs(n, used, path, ans);
        for(List<Integer> item : ans) {
            System.out.println(Arrays.toString(item.toArray()));
        }
        return new ArrayList<>();
    }


    private void dfs(int n, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if(path.size() == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!used[i-1]) {
                if(path.size() > 0 && Math.abs(i - path.get(path.size() - 1)) > 1) {
                    used[i - 1] = true;
                    path.add(i);
                    dfs(n, used, path, ans);
                    used[i-1] = false;
                    path.remove(path.size() - 1);
                }
                if(path.size() == 0) {
                    used[i - 1] = true;
                    path.add(i);
                    dfs(n, used, path, ans);
                    used[i-1] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        One one = new One();
        one.getSeq(5);
    }

}
