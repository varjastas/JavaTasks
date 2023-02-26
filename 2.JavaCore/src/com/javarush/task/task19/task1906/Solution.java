package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileInputStream = new FileReader(bufferedReader.readLine());
             FileWriter fileOutputStream = new FileWriter(bufferedReader.readLine())){

            int counter = 1;
            while (fileInputStream.ready()){
                int i = fileInputStream.read();
                if (counter % 2 == 0){
                    fileOutputStream.write(i);
                }
                counter += 1;
            }

        } catch (Exception e){

        }
    }
}
