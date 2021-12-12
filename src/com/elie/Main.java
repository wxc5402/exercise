package com.elie;

import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
	// write your code
        TreeSet set = new TreeSet();
        set.add(1);
        set.add(3);
        set.add(2);

        System.out.println(set.toString());


        TreeMap map = new TreeMap();
        map.put(1, 3);
        map.put(3,5);
        map.put(5,2);
        map.put(2,4);

        System.out.println(map.entrySet().toString());
    }
}
