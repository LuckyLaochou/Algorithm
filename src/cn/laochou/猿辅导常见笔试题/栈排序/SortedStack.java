package cn.laochou.猿辅导常见笔试题.栈排序;

import java.util.Stack;

/**
 * @Author: ITLaochou
 * @Date: 2020/7/4 0004 17:38
 * @Version: 1.0
 */
public class SortedStack {


    private Stack<Integer> stack;

    private Stack<Integer> temp;

    private int min;


    public SortedStack() {
        stack = new Stack<>();
        temp = new Stack<>();
        min = 0;
    }

    public void push(int val) {
        // 如果放入的值，大于当前的最小值
        if(val > min) {
            while (val > min ) {
                if(!stack.isEmpty()) {
                    min = stack.peek();
                    if(val > min) {
                        temp.push(stack.pop());
                    }
                }else {
                    break;
                }
            }
            stack.push(val);
            // 需要将temp的全部压回来
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            min = stack.peek();
        }else {
            stack.push(val);
            min = val;
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            if(!stack.isEmpty()) {
                min = stack.peek();
            }else {
                min = 0;
            }
        }
    }

    public int peek() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        System.out.println(sortedStack.min);
        sortedStack.pop();
        System.out.println(sortedStack.min);
    }

}
