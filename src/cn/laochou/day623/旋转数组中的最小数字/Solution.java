package cn.laochou.day623.旋转数组中的最小数字;

public class Solution {

    /**
     * 旋转数组中最小的数字
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        // 首先通过二分法解决
        int left = 0;
        int right = array.length - 1;
        int index = 0;
        // 我们left一定大于等于right
        while (array[left] >= array[right]) {
            if(right - left == 1) {
                index = right;
                break;
            }
            int mid = (left + right) / 2;
            if(array[left] == array[mid] && array[right] == array[mid]) {
                // 需要通过查找就行
                return findTarget(array);
            }
            if(array[left] <= array[mid]) {
                left = mid;
            }
            if(array[right] >= array[mid]) {
                right = mid;
            }
        }

        return array[index];
    }


    private int findTarget(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for(int v : array) {
            minValue = Math.min(v, minValue);
        }
        return minValue;
    }

}
