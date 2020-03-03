package com.example.arithmeticapplication.leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num155 {

    private Stack<Integer> mIntegerStack;
    private List<Integer> mList;
    /** initialize your data structure here. */
    public Num155() {
        mList = new ArrayList<>();
        mIntegerStack = new Stack<>();
    }

    public void push(int x) {
        mIntegerStack.push(x);
        int index = -1;
        for (int i = 0; i < mList.size(); i++) {
            if(mList.get(i) > x){
                index = i;
                break;
            }
        }
        if(index != -1){
            mList.add(index,x);
        }else{
            mList.add(x);
        }
    }

    public void pop() {
        int i = mIntegerStack.pop();
        for (int j = 0; j < mList.size(); j++) {
            if(mList.get(j) == i){
                mList.remove(j);
                break;
            }
        }
    }

    public int top() {
        return mIntegerStack.peek();
    }

    public int getMin() {
        if(mList.size() > 0){
            return mList.get(0);
        }
        return -1;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
