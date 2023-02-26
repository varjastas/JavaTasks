package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        String firstFileName = i.nextLine();
        String secondFileName = i.nextLine();
        try (BufferedReader secondBufferedReader = new BufferedReader(new FileReader(secondFileName));
             BufferedReader firstBufferedReader = new BufferedReader(new FileReader(firstFileName));
             BufferedWriter firstBufferedWriter = new BufferedWriter(new FileWriter(firstFileName))){

            String data = firstBufferedReader.lines().collect(Collectors.joining("\n"));
            firstBufferedWriter.write(secondBufferedReader.lines().collect(Collectors.joining("\n")));
            firstBufferedWriter.write(data);
        } catch (Exception e){
            System.out.println("Exception " + e);
        }

    }
}
