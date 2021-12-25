package com.elie.queueStack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FreqStack {
    int pushCount;
    PriorityQueue<int []> pq;
    Map<Integer, Integer> map;
    public FreqStack() {
        pushCount = 0;
        map = new HashMap<>();
        pq = new PriorityQueue<int[]>((a,b)->b[1] == a[1] ? b[2] - a[2]: b[1] - a[1]);
    }

    public void push(int val) {
        map.put(val,  map.getOrDefault(val, 0) + 1);
        pq.offer(new int[]{val, map.get(val), pushCount++});
    }

    public int pop() {
        int mostFreqEle = pq.peek()[0];
        map.put(mostFreqEle, map.get(mostFreqEle) - 1);
        return pq.poll()[0];
    }
}