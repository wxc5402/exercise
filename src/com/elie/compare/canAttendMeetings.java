package com.elie.compare;

import java.util.Arrays;

public class canAttendMeetings {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        for (int index = 0; index < intervals.length - 1; index ++) {
            if (intervals[index][1] > intervals[index + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
