package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        testString.printSomething();

        String[] result = outputStream.toString().split("\n");
        System.setOut(consoleStream);
        int counter = 0;
        for (int i = 0; i < result.length; i++) {
            counter += 1;
            System.out.println(result[i]);

            if (counter == 2){
                System.out.println("JavaRush - курсы Java онлайн");
                counter = 0;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
