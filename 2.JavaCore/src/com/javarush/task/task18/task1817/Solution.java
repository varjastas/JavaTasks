package com.javarush.task.task18.task1817;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];

        try (BufferedReader bufferedInputStream = new BufferedReader(new FileReader(fileName))){

            String data = bufferedInputStream.lines().collect(Collectors.joining(""));
            double spaces = 0;
            double notStapces = 0;
            for (char i:
                 data.toCharArray()) {

                if (String.valueOf(i).matches("\\s")){
                    spaces += 1;
                }
                notStapces += 1;

            }
            System.out.println(String.format("%.2f", spaces/notStapces*100));
        }catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}
