package org.example.lab12.compulsory;

import org.junit.Test;

public class Test1 {
    private int a;
    private int b;

    @Test
    public static void method1() {
        System.out.println("This is method 1");
    }

    public void method2(int a, int b) {
        System.out.println("a+b= " + (a+b));
    }

}