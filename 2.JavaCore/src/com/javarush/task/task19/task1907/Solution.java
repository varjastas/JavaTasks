package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        int counter = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(bufferedReader.readLine())){

            StringBuilder words = new StringBuilder();

            while (fileReader.ready()){
                words.append((char) fileReader.read());
            }

            String[] lines = words.toString().split("$");

            for (String i:
                 lines) {

                for (String j: i.split("\\W")) {

                    if (j.equals("world")){
                        counter += 1;
                    }
                }
            }
        } catch (Exception e){

        }
        System.out.println(counter);
    }
}
