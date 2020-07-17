package cn.laochou.day623.矩阵中的路径;


public class Solution {


    private int[][] direction = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, word, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] flag) {
        // 首先判断row和col是否出了边界
        if((row < 0 || row == board.length) || (col < 0 || col == board[0].length) || flag[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        if(index == word.length()-1) {
            return true;
        }
        flag[row][col] = true;
        boolean res = dfs(board, row, col + 1, word, index+1, flag) || dfs(board, row, col - 1, word, index+1, flag) || dfs(board, row + 1, col, word, index+1, flag) || dfs(board, row - 1, col, word, index+1, flag);
        flag[row][col] = false;
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
//        System.out.println(solution.exist(new char[][]{{'a'}}, "ab"));
//        System.out.println(solution.exist(new char[][]{{'a', 'a'}}, "aaa"));
        System.out.println(solution.exist(new char[][]{{'a', 'a'}}, "aa"));
    }

}
