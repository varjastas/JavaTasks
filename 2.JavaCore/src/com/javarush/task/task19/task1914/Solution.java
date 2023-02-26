package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething();

        String[] result = outputStream.toString().split(" ");
        System.setOut(consoleStream);

        String operand = result[1];
        String answer;
        if (operand.equals("+")){
            answer = String.valueOf(Integer.parseInt(result[0]) + Integer.parseInt(result[2]));
        } else if (operand.equals("-")) {
            answer = String.valueOf(Integer.parseInt(result[0]) - Integer.parseInt(result[2]));
        } else {
            answer = String.valueOf(Integer.parseInt(result[0]) * Integer.parseInt(result[2]));
        }
        System.out.println(String.format("%s %s %s = %s", result[0], operand, result[2], answer));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

