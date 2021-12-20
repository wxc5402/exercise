package com.elie.compare;

import java.util.*;
import java.util.stream.Collectors;

public class minAttendMeetings {

    public static void main (String[] args) {


    }

    public static int minAttendMeetings(int[][] intervals) {
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

        return res;
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
