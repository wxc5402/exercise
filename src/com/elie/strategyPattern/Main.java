package com.elie.strategyPattern;

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
