package com.elie.queueStack;

import java.util.LinkedList;
import java.util.Queue;

class MyQueue2 {

    Queue<Integer> q1, q2;
    int top = 0;
    public MyQueue2() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    public int pop() {
        while(q1.size() > 1) {
            top = q1.poll();
            q2.offer(q1.poll());

        }

        int value = q1.poll();

        Queue<Integer> tempQ = q1;
        q1 = q2;
        q2 = tempQ;
        return value;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */