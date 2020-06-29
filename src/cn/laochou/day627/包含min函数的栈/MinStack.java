package cn.laochou.day627.包含min函数的栈;

import java.util.Stack;

public class MinStack {


    private Stack<Integer> stack;
    // 辅助栈
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        // 使用两个栈，辅助栈
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // 获取最小值
        if(!minStack.isEmpty()) {
            int min = minStack.peek();
            if(x < min) min = x;
            minStack.push(min);
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }
        return 0;
    }

    public int min() {
        if(!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }

}
