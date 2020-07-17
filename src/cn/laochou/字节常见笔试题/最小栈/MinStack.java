package cn.laochou.字节常见笔试题.最小栈;

import java.util.Stack;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/3 0003 19:55
 * @Version: 1.0
 */
public class MinStack {

    // 使用辅助栈
    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // 需要判断辅助栈
        if(!minStack.isEmpty()) {
            int min = minStack.peek();
            min = min < x ? min : x;
            minStack.push(min);
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
        if(!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

}
