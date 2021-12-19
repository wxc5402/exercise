package com.elie.compare;

import java.util.Arrays;
import java.util.Comparator;

public class canAttendMeetings {

    public static void main (String[] args) {
        int[][] nums = {{0,5},  {15,20}, {5,10}};
        boolean ret = canAttendMeetings(nums);
        int k = 0;
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        //Arrays.sort(intervals, new MyCompator());

        for (int index = 0; index < intervals.length - 1; index ++) {
            if (intervals[index][1] > intervals[index + 1][0]) {
                return false;
            }
        }
        return true;
    }
}

class MyCompator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
    }
}
