package com.elie;

import com.elie.heapify.Heapify;
import com.elie.strategyPattern.Context;
import com.elie.strategyPattern.OperationAdd;
import com.elie.strategyPattern.OperationMultiply;
import com.elie.strategyPattern.OperationSubstract;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();


        q1.offer(2);
        q1.offer(3);
        q1.offer(4);

        System.out.println(q1.peek());
    }
}
