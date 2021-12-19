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

        Context context = new Context(new OperationAdd());
        int result = context.executeStrategy(3, 2);

        context = new Context(new OperationSubstract());
        result = context.executeStrategy(4, 2);

        context = new Context(new OperationMultiply());
        result = context.executeStrategy(5, 2);

        System.out.println(result);
    }
}
