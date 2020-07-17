package cn.laochou.字节常见笔试题.用Rand7实现Rand10;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/7 0007 11:42
 * @Version: 1.0
 */
public class Solution {

    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        }while(idx > 40);
        return 1 + (idx - 1) % 10;
    }


    /**
     * 这个由系统提供。
     * @return
     */
    private int rand7() {
        return 0;
    }

}
