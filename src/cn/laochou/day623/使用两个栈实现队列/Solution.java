package cn.laochou.day623.使用两个栈实现队列;

import java.util.Stack;

public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * push 我们push stack1 中
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 当pop，我们先考虑 stack2中是否有，如果有，就先从stack2 pop。
     * 当stack为空的时候，我们将stack1 中是数据push到Stack2 中，让stack1只剩下一个。
     * 如何返回接口。
     * @return
     */
    public int pop() {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        }else {
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            return stack1.pop();
        }
    }

}
