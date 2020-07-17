package cn.laochou.字节常见笔试题.中位数;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/5 0005 21:38
 * @Version: 1.0
 */
public class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for(int i = 0; i <= len / 2; i++) {
            left = right;
            if(aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            }else {
                right = B[bStart++];
            }
        }

        if((len & 1) == 0) {
            return (left + right) / 2.0;
        }else {
            return right;
        }
    }

}
