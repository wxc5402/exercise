package com.elie.compare;

import java.util.*;
import java.util.stream.Collectors;

public class minAttendMeetings {

    public static void main (String[] args) {


    }

    public static int minAttendMeetings(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }

        /*
        List<Node> list = new ArrayList<>();
        for (int[] inter : intervals) {
            list.add(new Node(inter[0], 1));
            list.add(new Node(inter[1], -1));
        }

        Collections.sort(list);

        int val = 0;
        int res = 0;
        for (Node no : list) {
            val += no.value;
            res = Math.max(res, val);
        }

        return res;         */
        return allocator.size();
    }
}

class Node implements Comparable<Node> {
    int time;
    int value;

    public Node(int time, int value) {
        this.time = time;
        this.value = value;
    }

    @Override
    public int compareTo(Node other) {
        return this.time == other.time ? this.value - other.value : this.time - other.time;
    }
}
