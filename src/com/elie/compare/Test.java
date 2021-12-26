package com.elie.compare;

import jdk.dynalink.beans.StaticClass;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Integer[] nums = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        Arrays.sort(nums, new MyComparator());
        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums, new MyComparator2());
        System.out.println(Arrays.toString(nums));


        Integer[] nums1 = {2, 3, 1};

        Arrays.sort(nums1, (a, b)-> a - b);

        int j = 0;
    }
}

class MyComparator2 implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1) ;
    }
}