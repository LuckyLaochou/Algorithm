package cn.laochou.day627.栈的压入弹出序列;

import java.util.Stack;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushNext = 0;
        int popNext = 0;
        int length = pushed.length;
        while (popNext < length) {
            while (stack.isEmpty() || stack.peek() != popped[popNext]) {
                if(pushNext == length) {
                    break;
                }
                stack.push(pushed[pushNext++]);
            }
            if(stack.peek() != popped[popNext]) {
                break;
            }
            stack.pop();
            popNext++;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }

}
