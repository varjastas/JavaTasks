package com.javarush.task.pro.task14.task1414;

/* 
Готовим коктейли
*/


public class Solution {

    public static final String OUTPUT_FORMAT = "Метод %s вызван из строки %d класса %s в файле %s.\n";

    public static void main(String[] args) {
        makeScrewdriver();
    }

    public static void printStackTrace(StackTraceElement[] stackTrace) {
        for (StackTraceElement i:
             stackTrace) {
            System.out.printf("Метод %s вызван из строки %s класса %s в файле %s.\n", i.getMethodName(), i.getLineNumber(), i.getClassName(), i.getFileName());
        }
    }

    static void makeScrewdriver() {
        addJuice();
    }

    static void addJuice() {
        addVodka();
    }

    static void addVodka() {
        printStackTrace(Thread.currentThread().getStackTrace());
    }
}
