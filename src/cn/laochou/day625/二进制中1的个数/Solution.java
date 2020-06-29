package cn.laochou.day625.二进制中1的个数;

public class Solution {

    /**
     * AC
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int flag = 1;
        int count = 0;
        while(n != 0) {
            if((n & flag) > 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(11));
    }

}
