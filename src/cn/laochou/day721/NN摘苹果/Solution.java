package cn.laochou.day721.NN摘苹果;

import java.util.Arrays;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/21 0021 15:28
 * @Version: 1.0
 */
public class Solution {


    /**
     * 作者：今天也是没有收到offer的一天
     * 链接：https://www.nowcoder.com/discuss/451758
     * 来源：牛客网
     *
     * 题意
     *     牛牛有一个苹果园。又到了一年一度的收获季，牛牛现在要去采摘苹果买给市场的摊贩们。
     *     牛牛的果园里面有n棵苹果树，第i棵苹果树上有ai个果子。
     *     牛牛为了保证果子的新鲜程度，每天都会去苹果树上采摘果子。
     *     牛牛特意安排一个计划表：
     *     计划m天去采摘果子。
     *     对于第i天，它会去所有果树上轮流采摘bi个果子。
     *     如果对于第i天，某棵果树上没有bi个果子，那么它只会把当前果树上的果子采摘完。
     *     牛牛想知道它每天能供应多少个苹果给市场的摊贩们。
     * 示例1
     *     输入    [10,20,10],[5,7,2]
     *     输出    [15,17,2]
     * @param apples
     * @param needs
     * @return
     */
    public int[] pickApple(int[] apples, int[] needs) {
        int days = needs.length;
        int[] ans = new int[days];
        for(int i = 0; i < days; i++) {
            for(int j = 0; j < apples.length; j++) {
                if(apples[j] > needs[i]) {
                    apples[j] = apples[j] - needs[i];
                    ans[i] += needs[i];
                }else {
                    ans[i] += apples[j];
                    apples[j] = 0;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.pickApple(new int[]{10, 20, 10}, new int[]{5, 7, 2})));
    }

}
