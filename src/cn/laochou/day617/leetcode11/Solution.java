package cn.laochou.day617.leetcode11;

public class  Solution {

    /**
     * AC
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int high;
        while (left < right) {
            high = Math.min(height[left], height[right]);
            maxArea = Math.max(high * (right - left), maxArea);
            if(height[left] > height[right]) {
                right--;
            }else {
                left++;
            }
        }
        return maxArea;
    }

}
