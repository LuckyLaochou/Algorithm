package cn.laochou.day626.旋转图像;

public class Solution {

    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        // 先通过对角线转置
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 然后对于每一列进行转换
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


    public static void main(String[] args) {
         Solution solution = new Solution();
         int[][] matrix = new int[][] {
                 {5, 1, 9,11},
                 {2, 4, 8,10},
                 {13, 3, 6, 7},
                 {15,14,12,16}
         };
         solution.rotate(matrix);
         for(int i = 0; i < matrix.length; i++) {
             for(int j = 0; j < matrix.length; j++) {
                 System.out.print(matrix[i][j] + " ");
             }
             System.out.println();
         }
    }

}
