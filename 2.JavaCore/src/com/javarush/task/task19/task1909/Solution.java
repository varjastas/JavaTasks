package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileInputStream = new BufferedReader(new FileReader(bufferedReader.readLine()));
             BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(bufferedReader.readLine()))) {

            String res = fileInputStream.lines().collect(Collectors.joining("\n")).replaceAll("\\.", "!");


            fileOutputStream.write(res);

        } catch (Exception e) {

        }

    }
}
