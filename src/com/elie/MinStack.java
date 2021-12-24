package com.elie;

import java.util.LinkedList;
import java.util.Stack;

class MinStack {

    Stack<Integer[]> stack = new Stack<Integer[]>();

    public MinStack() {
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new Integer[]{val, val});
            return;
        }

        int min = stack.peek()[1];
        stack.push(new Integer[]{val, Math.min(val, min)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.pop()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}