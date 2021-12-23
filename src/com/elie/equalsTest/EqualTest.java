package com.elie.equalsTest;

public class EqualTest {

    public static void main(String[] args) {
        Employee e1 = new Employee();

        Employee e2 = new Employee();


        e1.setId(100);
        e1.setFirstName("1");

        e2.setId(100);
        e2.setFirstName("1");

        System.out.println(e1.equals(e2));
    }
}
