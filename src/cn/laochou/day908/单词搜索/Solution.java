package cn.laochou.day908.单词搜索;

public class Solution {

    public boolean exist(char[][] board, String word) {
        // 判断board是否有word的存在
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(int i, int j, char[][] board, String word, int index) {
        if(index == word.length()) {
            return true;
        }
        if((i < 0 || i >= board.length) || (j < 0 || j >= board[0].length) || word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean flag = dfs(i + 1, j, board, word, index + 1) || dfs(i - 1, j , board, word, index + 1) || dfs(i, j + 1, board, word, index + 1) || dfs(i, j - 1, board, word, index + 1);
        board[i][j] = temp;
        return flag;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

}
