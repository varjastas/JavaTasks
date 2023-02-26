package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream systemOut = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ourPrintStream = new PrintStream(byteArrayOutputStream);

        System.setOut(ourPrintStream);

        testString.printSomething();
        
        System.setOut(systemOut);
        String result = byteArrayOutputStream.toString();
        System.out.println(result.toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
