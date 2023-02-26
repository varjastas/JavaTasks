package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String fileName = "";
        try (BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in))){
            fileName = bufferedReader.readLine();

        } catch (Exception e){

        }
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething();

        String result = outputStream.toString();
        System.setOut(consoleStream);
        System.out.println(result);
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)){

            fileOutputStream.write(result.getBytes());
        } catch (Exception e){

        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

