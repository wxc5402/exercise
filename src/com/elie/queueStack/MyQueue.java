package com.elie.queueStack;

import java.util.Stack;

class MyQueue {
    Stack<Integer> queue;
    Stack<Integer> stack;

    public MyQueue() {
        queue = new Stack<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (queue.isEmpty()) {
            queue.push(x);
            return;
        }

        while(!queue.isEmpty()) {
            stack.push(queue.pop());
        }
        queue.push(x);
        while(!stack.isEmpty()) {
            queue.push(stack.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */